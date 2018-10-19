package kr.kw.service.floor1;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet1FCollection;

public class F1LightService extends Floor1Relation {

	// light 06, 07 off
	private static final int MODE_2 = 1;		
	
	// light 08, 09 off
	private static final int MODE_3 = 2;		
	
	// light 06 off
	private static final int MODE_4 = 3;		
	
	// light 07 off
	private static final int MODE_5 = 4;
	
	// light 08 off
	private static final int MODE_6 = 5;
	
	// light 09 off
	private static final int MODE_7 = 6;
	
	// light 06 on
	private static final int MODE_8 = 7;

	// light 07 on
	private static final int MODE_9 = 8;
	
	// light 08 on
	private static final int MODE_10 = 9;
	
	// light 09 on
	private static final int MODE_11 = 10;
	
	// light 06, 07 on
	private static final int MODE_12 = 11;
	
	// light 08, 09 on
	private static final int MODE_13 = 12;
		
	private int tagid;
	private int location;

	public F1LightService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_6, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting6(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
		
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_7, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting7(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_8, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting8(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_9, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting9(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_6, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting6(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_7, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting7(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_8, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting8(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_9, UtasLightFunction.OFF)) {
				process.controlDevice(Packet1FCollection.lighting9(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_8:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_6, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting6(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
			break;
		case MODE_9:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_7, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting7(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_10:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_8, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting8(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_11:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_9, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting9(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_12:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_6, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting6(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_7, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting7(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_13:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_8, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting8(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_9, UtasLightFunction.ON)) {
				process.controlDevice(Packet1FCollection.lighting9(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
