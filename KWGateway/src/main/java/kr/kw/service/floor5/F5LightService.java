package kr.kw.service.floor5;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet5FCollection;

public class F5LightService extends Floor5Relation {

	// light (0A) off
	private static final int MODE_2 = 1;		
	
	// light (0A) on
	private static final int MODE_3 = 2;		
	
	// light (0B) off
	private static final int MODE_4 = 3;		
	
	// light (0B) on
	private static final int MODE_5 = 4;
	
	// light (0C) off
	private static final int MODE_6 = 5;
	
	// light (0C) on
	private static final int MODE_7 = 6;
	
	// light (0A) (0B) off
	private static final int MODE_8 = 7;

	// light (0A) (0B) on
	private static final int MODE_9 = 8;
	
		
	private int tagid;
	private int location;

	public F5LightService(int tagid, int location) {
		this.tagid = tagid;
		this.location = location;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[5];
		instances[0] = getTagIdPosition(tagid);
		instances[1] = getLocation(location);
		instances[2] = getDatePosition();
		instances[3] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		// TODO Auto-generated method stub
		switch(predict) {
		case MODE_2:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_10, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.lighting10(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_10, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.lighting10(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_11, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.lighting11(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_11, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.lighting11(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_12, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.lighting12(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_12, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.lighting12(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_8:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_10, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.lighting10(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_11, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.lighting11(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			break;
		case MODE_9:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_10, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.lighting10(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_11, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.lighting11(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}

}
