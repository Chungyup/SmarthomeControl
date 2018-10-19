package kr.kw.connect.receiver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.device.DeviceFactory;
import kr.kw.device.SHSensor;
import kr.kw.protocol.BMSProtocol;
import kr.kw.util.KWLOG;
import kr.re.keti.socket.IKETIClientReceiver;
import kr.re.keti.socket.KETISockError;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacket;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.IType;

/**
 * class to receive data from home appliance
 * 
 * **/
public class BMSReceiver implements IKETIClientReceiver {
	private static final String TAG = "BMSReceiver";

	private GWProcess process;
	private Gson gson;
	
	public BMSReceiver(GWProcess process) {
		this.process = process;
		gson = new GsonBuilder().create();
	}
	
	public void receiveString(String message) {
		KMessage header = KMessage.getMessage(message);
		
		if(header.getMt() == MessageType.REQUEST
				&& header.getCmd() == Commend.RETREIVE
				&& header.getCt() == Content.GATEWAY
				&& header.getCtt() == ContentType.NONE) {
			process.send(new Post(To.BMS, 
					BMSProtocol.resGateway(process.getGateway())));
		} else if(header.getMt() == MessageType.REQUEST
				&& header.getCmd() == Commend.RETREIVE
				&& header.getCt() == Content.HOMEAPPLIANCE
				&& header.getCtt() == ContentType.JSON_LIST) {
			process.send(new Post(To.BMS, BMSProtocol.resHAList()));
		} else if(header.getMt() == MessageType.REQUEST
				&& header.getCmd() == Commend.RETREIVE
				&& header.getCt() == Content.SENSOR
				&& header.getCtt() == ContentType.JSON_LIST) {
			process.send(new Post(To.BMS, BMSProtocol.resSensorList()));
		} 
		
		
		else if(header.getMt() == MessageType.NOTI
				&& header.getCmd() == Commend.UPDATE
				&& header.getCt() == Content.SENSOR
				&& header.getCtt() == ContentType.JSON) {
		
			MaxforPacket mPacket = gson.fromJson(gson.toJson(header.getData()), MaxforPacket.class);
			SHSensor sensor = DeviceFactory.make(mPacket);
//			System.out.println(sensor.toString());
			process.collect(IType.SENSOR, sensor);
			
			if(sensor != null) {
				process.scenario(sensor);
			}
		} 
		
		
		else if(header.getMt() == MessageType.EMERGENCY) {
			System.out.println("E M E R G E N C Y !");
		}
	}

	public void receiveByte(byte[] packet, int length) {
		// NOTHING TO DO
	}
	
	public void onConnected(String message) {
		KWLOG.info(TAG, "connected: " + message);
	}

	public void onDisconnected(String message) {
		KWLOG.info(TAG, "disconnected: " + message);
	}

	public void onError(int id, String message) {
		KWLOG.debug(TAG, "err: " + message);
		
		switch(id) {
		case KETISockError.ERR_CONNECT:
		case KETISockError.ERR_DISCONNECT:
		case KETISockError.ERR_INPUT:
		case KETISockError.ERR_OUTPUT:
			// try to reconnect
			process.reconnect(To.BMS);
		}
	}

	public void uploadFile(String file) {
		// TODO Auto-generated method stub
		
	}
}
