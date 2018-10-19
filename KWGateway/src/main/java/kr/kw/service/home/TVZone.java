package kr.kw.service.home;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasRS232TVFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.PacketSHCollection;

public class TVZone extends HomeRelation {

	private static final int MODE_ON_CHANNEL_10_1 = 1;
	private static final int MODE_ON_CHANNEL_10_2 = 2;
	private static final int MODE_ON_CHANNEL_7_1 = 3;
	private static final int MODE_ON_CHANNEL_11_1 = 4;
	private static final int MODE_OFF = 5;
	
	private int prelocation;
	private int location1;
	private int location2;
	private int location3;
	
	public TVZone(int prelocation, int location1, int location2, int location3) {
		this.prelocation = prelocation;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[7];
		instances[0] = getLocation(prelocation);
		instances[1] = getLocation(location1);
		instances[2] = getLocation(location2);
		instances[3] = getLocation(location3);
		instances[4] = getDatePosition();
		instances[5] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		switch(predict) {
		case MODE_ON_CHANNEL_10_1:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.ON)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.ON), UtasPacketTimer.INTERVAL_TV);
			}
			
			process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.CHANNEL_10_1), UtasPacketTimer.INTERVAL_CTR);
			break;
		case MODE_ON_CHANNEL_10_2:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.ON)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.ON), UtasPacketTimer.INTERVAL_TV);
			}
			
			process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.CHANNEL_10_2), UtasPacketTimer.INTERVAL_CTR);
			break;
		case MODE_ON_CHANNEL_7_1:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.ON)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.ON), UtasPacketTimer.INTERVAL_TV);
			}
			
			process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.CHANNEL_7_1), UtasPacketTimer.INTERVAL_CTR);
			break;
		case MODE_ON_CHANNEL_11_1:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.ON)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.ON), UtasPacketTimer.INTERVAL_TV);
			}
			
			process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.CHANNEL_11_1), UtasPacketTimer.INTERVAL_CTR);
			break;
		case MODE_OFF:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.OFF)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.OFF), UtasPacketTimer.INTERVAL_TV);
			}
			break;
		}
	}

}
