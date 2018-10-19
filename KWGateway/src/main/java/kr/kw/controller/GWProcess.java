package kr.kw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.kw.connect.Connector;
import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.data.DataCollector;
import kr.kw.data.DataDeletor;
import kr.kw.data.DataRetrievor;
import kr.kw.data.UserRegister;
import kr.kw.device.DeviceFactory;
import kr.kw.device.SHHomeAppliance;
import kr.kw.device.SHMirrorTV;
import kr.kw.device.SHSensor;
import kr.kw.gateway.KWGateway;
import kr.kw.protocol.BMSProtocol;
import kr.kw.protocol.MashupProtocol;
import kr.kw.protocol.MirrorTVProtocol;
import kr.kw.protocol.MonitoringProtocol;
import kr.kw.service.CAPack;
import kr.kw.service.Emergency;
import kr.kw.service.GWService;
import kr.kw.service.SHService;
import kr.kw.service.ServiceRunner;
import kr.kw.service.contextawareness.ContextAcquisition;
import kr.kw.service.contextawareness.ContextAwareness;
import kr.kw.service.contextawareness.ContextAwarenessEvent;
import kr.kw.service.contextawareness.Relation;
import kr.kw.service.contextawareness.arff.ARFF;
import kr.kw.service.contextawareness.arff.ARFFFactory;
import kr.kw.user.GWUser;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.DBManager;
import kr.kw.workingmemory.ReceiverManager;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacket;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacketBuffer;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacketManager;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.UtasReqManager;
import re.kr.keti.shprotocol.item.Collectable;
import re.kr.keti.shprotocol.item.Deletable;
import re.kr.keti.shprotocol.item.Gateway;
import re.kr.keti.shprotocol.item.HomeAppliance;
import re.kr.keti.shprotocol.item.IType;
import re.kr.keti.shprotocol.item.Retrievable;
import re.kr.keti.shprotocol.item.Schedule;
import re.kr.keti.shprotocol.item.Service;
import re.kr.keti.shprotocol.item.Smartphone;

/**
 * KWGateway 프로그램 전체를 제어하는 클래스
 * 
 * 아래와 같은 일을 수행한다.
 * 1. 데이터 수집
 * 2. 데이터 정보 전송
 * 3. 상황인지
 * */
public class GWProcess {
	private static final String TAG = "GWProcess";

	private Gateway gateway;
	
	// connect
	private Connector connector;

	// data storage
	private WorkingMemory wkmm;
	private DBManager dbm;
	private DataCollector dtctr;
	private DataDeletor dtdlt;
	private DataRetrievor dtrtv;
	
	// context awareness
	private ContextAcquisition contextAcquisition;
	private ContextAwareness contextAwareness;
	private ContextAwarenessEvent event;
	private ServiceRunner sRunner;
	private List<ARFF> arffs;
	
	// maxfor
	private MaxforPacketManager bufferManager;
	
	// utas
	private UtasReqManager utasReqManager;
	
	public GWProcess() {
		// initialize
		gateway = null;
		connector = new Connector(ReceiverManager.getInstance(this));
		
		wkmm = WorkingMemory.getInstance();
		dbm = DBManager.getInstance();
		dtctr = new DataCollector(wkmm, dbm);
		dtdlt = new DataDeletor(wkmm, dbm);
		dtrtv = new DataRetrievor(wkmm, dbm);
		
		contextAcquisition = new ContextAcquisition();
		contextAwareness = new ContextAwareness();
		event = new ContextAwarenessEvent();
		sRunner = new ServiceRunner(contextAwareness, this, wkmm.getHAManager());
		
		bufferManager = new MaxforPacketManager();
		utasReqManager = new UtasReqManager();
	}
	
	/**
	 * 게이트웨이 정보 확인
	 * 
	 * 1. 디비에 게이트웨이 정보가 등록되어있는지 확인
	 * 2. 등록되어있지 않다면 등록
	 * 
	 * @param KWGateway 게이트웨이 정보
	 * */
	public void checkGateway(Gateway gatewayInfo) {
		// 기존 정보 가져오기
		gateway = dbm.getGatewayDB().selectGateway(gatewayInfo);

		// 등록된 정보가 없다면 등록
		if(gateway == null) {
			if(dbm.getGatewayDB().insertGateway(gatewayInfo) > 0) {
				gateway = gatewayInfo;
				KWLOG.info(TAG, "gateway info.: " + gatewayInfo.toString());
			} else {
				KWLOG.debug(TAG, "fail to register gateway.");
			}
		} else {
			KWLOG.info(TAG, "gateway info.: " + gateway.toString());
		}
	}
	
	public void startCommunicate()  {
		// try to connect all
		if(connector != null) {
			connector.connectAllServer();
			connector.connectAllClient();
			connector.connectAllSerial();
			KWLOG.info(TAG, "start communication");
		}
	}
	
	public void initContextAwareness() {
		if(GWService.use) {
			arffs = ARFFFactory.getARFF(KWGateway.LOCATION, KWGateway.FLOOR);
			
			if(arffs != null) {
				for (ARFF arff : arffs) {
				   String relation = contextAwareness.setWekaInstanceFromARFF(arff.getFile());
				   if(relation != null) {
					   SHService service = new SHService(gateway.getGwId(), relation);
					   wkmm.getServiceManager().add(service);
					   arff.setService(service);		   
				   }
				}
			}
		}
	}
	
	public void addContextAwareness(String name) {
		if(GWService.use) {
			ARFF arff = ARFFFactory.getARFF(KWGateway.LOCATION, KWGateway.FLOOR, name);
			if(arff != null) {
				String relation = contextAwareness.setWekaInstanceFromARFF(arff.getFile());
				if(relation != null) {
					SHService service = new SHService(gateway.getGwId(), relation);
					wkmm.getMashupManager().delete(service);
					wkmm.getServiceManager().add(service);
					arff.setService(new SHService(gateway.getGwId(), relation));		   
					send(new Post(To.MASHUP, MashupProtocol.register(service)));
					send(new Post(To.MONITORING, MonitoringProtocol.updateService(service)));	
				}
			}
		}
	}
	
	public void updateMashup(List<Service> services) {
		wkmm.getMashupManager().put(services);
		
		send(new Post(To.MONITORING, MonitoringProtocol.updateMashup(services)));
	}
	
	public void updateLocation(Smartphone smartphone) {
		send(new Post(To.MIRRORTV, MonitoringProtocol.notiLoc(smartphone)));
	}
	
	public void registerUsers() {
		new UserRegister(wkmm, dbm).todo(gateway);
	}
	
	public void controlDevice(UtasPacket packet, int delay) {
//		System.out.println("CONTROL= "  + packet.getDevice() + " : " + packet.getDeviceNo());
		utasReqManager.addReqPacket(packet);
		connector.sendToUtasController(packet.makeCtrWrite());	
		UtasPacketTimer.DELAY(delay);
	}
	
	public void analyzeMaxforPacket(final String key, byte[] packet, int length) {
		MaxforPacketBuffer buffer = null;

		// get a packet
		if(!bufferManager.isBuffer(key)) {
			buffer = bufferManager.addBuffer(key);
		} else {
			buffer = bufferManager.getBuffer(key);
		}
		buffer.append(packet, length);

		// extract an available packet
		
		byte[] ext = buffer.extract();

		// if the packet is not dummy, collect a sensor
		while(!MaxforPacket.isDummy(ext)) {
			MaxforPacket mPacket = new MaxforPacket(ext);
			if(!DeviceFactory.filterSensor(mPacket.getDeviceGroup(), mPacket.getDeviceId())) {
				SHSensor sensor = DeviceFactory.make(mPacket);
				sensor = (SHSensor) collect(IType.SENSOR, sensor);

				if(sensor != null) {
					KWLOG.info(TAG, sensor.toString());
					send(new Post(To.MONITORING, MonitoringProtocol.notiSensor(sensor)));
					send(new Post(To.BMS, BMSProtocol.notiSensor(sensor)));
					scenario(sensor);
				}	
			}
			
			ext = buffer.extract();
		}
	}
	
	public void analyzeUtasPacket(byte[] packet, int length) {
		int modbusFC = packet[7];
		switch(modbusFC) {
		case UtasModbusFC.CONTROL:
			// find if there is a request packet
			UtasPacket reqPacket = utasReqManager.findReqPacket(
					UtasPacket.getDevice(packet),  
					UtasPacket.getDeviceNo(packet));

			// if there is a request packet, collect home appliance
			if(reqPacket != null) {
				UtasPacket uPacket = new UtasPacket(
						reqPacket.getDevice(),
						reqPacket.getDeviceNo(),
						reqPacket.getZone(),
						reqPacket.getFunction());
				
				SHHomeAppliance uha = DeviceFactory.make(uPacket);
				HomeAppliance ha = (HomeAppliance) collect(IType.HA, uha);
				if(ha != null) {
					KWLOG.info(TAG, ha.toString());
					send(new Post(To.MONITORING, MonitoringProtocol.notiHA(ha)));
					send(new Post(To.BMS, BMSProtocol.notiHA(ha)));
				}
			} else {
				KWLOG.debug(TAG, "unknown response message");
			}
			break;
		case UtasModbusFC.STATE_CHECK:

			break;
		case UtasModbusFC.NOTI:
			UtasPacket uPacket = new UtasPacket(packet);
			SHHomeAppliance uha = DeviceFactory.make(uPacket);
			HomeAppliance ha = (HomeAppliance) collect(IType.HA, uha);
			if(ha != null) {
				KWLOG.info(TAG, ha.toString());
				send(new Post(To.MONITORING, MonitoringProtocol.notiHA(ha)));
				send(new Post(To.BMS, BMSProtocol.notiHA(ha)));
			}
			break;
		}
	}

	public Object collect(IType type, Collectable item) {
		switch(type) {
		case SENSOR:
			SHSensor sensor = (SHSensor) item;
			return dtctr.collect(sensor);
		case HA:
			SHHomeAppliance ha = (SHHomeAppliance) item;
			return dtctr.collect(ha);
		case SCHD:
			Schedule schedule = (Schedule) item;
			return dtctr.collect(schedule);
		case PHONE:
			Smartphone phone = (Smartphone) item;
			return dtctr.collect(phone);
		case MIRRORTV:
			SHMirrorTV mtv = (SHMirrorTV) item;
			return dtctr.collect(mtv);
		case SERVICE:
			Service service = (Service) item;
			return dtctr.collect(service);
		default:
			break;
		}
		
		return null;
	}
	
	public Object delete(IType type, Deletable item) {
		switch(type) {
		case SCHD:
			Schedule schedule = (Schedule) item;
			return dtdlt.delete(schedule);
		case MIRRORTV:
			SHMirrorTV mtv = (SHMirrorTV) item;
			return dtdlt.delete(mtv);
		default:
			break;
		}
		
		return null;
	}
	
	public Object retrieve(IType type, Retrievable item) {
		switch(type) {
		case SCHD:
			Schedule schedule = (Schedule) item;
			return dtrtv.retrieve(schedule);
		default:
			break;
		}
		
		return null;
	}
	
	public void send(Post post) throws NullPointerException {
		switch(post.getTo()) {
		case BMS:
			connector.sendToBMS(post.getMesasge());
			break;
		case HA:
			break;
		case MASHUP:
			connector.sendToMashup(post.getMesasge());
			break;
		case MASHUPFILE:
			connector.sendToMashupFile(post.getMesasge());
			break;
		case MIRRORTV:
			if(post.getClient() != null)
				connector.sendToMirrorTV(post.getClient(), post.getMesasge());	
			else
				connector.broadcastMirrorTV(post.getMesasge());
			break;
		case APP:
			connector.sendToAPP(post.getClient(), post.getMesasge());
			break;
		case MONITORING:
//			if(post.getClient() != null)
//				connector.sendToMonitoring(post.getClient(), post.getMesasge());
//			else
			connector.broadcastToMonitoring(post.getMesasge());
			break;
		default:
			break;
		}
	}
	
	public void scenario(SHSensor sensor) {
		if(sensor == null)
			return;
		
		final int sgrp = sensor.getSensorGroup();
		
		/*
		 * event priority
		 * 1. emergency
		 * 2. screen
		 * 3. service
		 */
		if(event.emergency(sgrp)) {
			new Emergency(this).run(sensor);
		}
		
		GWUser user = wkmm.getUserManager().getUser(sensor.getDeviceId());
		if(user != null) {
			user.changeLocation();
		}
		
		if(event.screen(sgrp)) {
			if(user != null) {
				List<SHMirrorTV> mtvs = wkmm.getMirrorTVManager().updateOnOff(wkmm.getUserManager().getUsers());
				for(SHMirrorTV mtv : mtvs) {
//					System.out.println(mtv.toString());
//					System.out.println(MirrorTVProtocol.notiUpdate(mtv));
					send(new Post(To.MIRRORTV, mtv.getClient(), MirrorTVProtocol.notiUpdate(mtv.getBrtn())));	

					if(user != null) {
						@SuppressWarnings("unchecked")
						List<Schedule> rscd = (List<Schedule>) retrieve(IType.SCHD, new Schedule(user.getMphnb()));
						send(new Post(To.MIRRORTV, mtv.getClient(), MirrorTVProtocol.resRetrieve(rscd)));
					}
				}
			}
		}
		
		if(event.cause(sgrp, user)) {
			if(arffs != null) {
				List<CAPack> caPacks = new ArrayList<CAPack>();
				
				for (ARFF arff : arffs) {
					if(arff.getLocation() == user.getPreLoc() || arff.getLocation() == user.getCurLoc()
							|| arff.getLocation() == 0) {
						Relation relation = contextAcquisition.obtain(user, arff, wkmm);

						if(relation != null && arff.getService() != null) {
							// sync
//							contextAwareness(arff, relation);
							
							// async
							caPacks.add(new CAPack(arff, relation));
						}
					}
				}
				
				sRunner.start(caPacks);
			}
		}
		
		ARFF eArff = null;
		if((eArff = event.cause(sgrp)) != null) {
			if(arffs != null) {
				List<CAPack> caPacks = new ArrayList<CAPack>();
				
				for (ARFF arff : arffs) {
					if(eArff.getFile().equals(arff.getFile())) {
						Relation relation = contextAcquisition.obtain(user, arff, wkmm);

						if(relation != null) {
							// sync
//							contextAwareness(arff, relation);
							
							// async
							caPacks.add(new CAPack(arff, relation));
						}
						
						break;
					}
					
				}
				
				sRunner.start(caPacks);
			}
		}
	}
	
	public void contextAwareness(ARFF service, Relation relation) {
		if(GWService.use) {
			double predict = contextAwareness.wekaClassify(service.getFile(), relation.getInstances());
			
			if(predict >= 0) {
				relation.setPredict((int) predict);
				
				relation.start(this, wkmm.getHAManager());
			}
		}
	}
	
	public boolean checkHAOnOff(int device, int deviceN, int func) {
		return wkmm.getHAManager().equalOnOff(device, deviceN, func);
	}
	
	public Gateway getGateway() {
		return gateway;
	}
	
	public boolean is7FAllPPL() {
		Map<Integer, Integer> users = wkmm.getSensorManager().getUsers();
		int user14 = users.get(14);
		int user21 = users.get(21);
		int user22 = users.get(22);
		
		return 10022 == user14 || 10022 == user21 || 10022 == user22;
	}
	
	public void reconnect(To type) {
		try {
			connector.reconnect(type);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finish() {
		connector.finish();
		contextAwareness.finish();
	}
}
