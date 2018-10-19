package kr.kw.service.floor7;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet7FCollection;

public class F7LightService extends Floor7Relation {

	// light (10) off
	private static final int MODE_2 = 1;		
	
	// light (10) on
	private static final int MODE_3 = 2;		
	
	// light (11) off
	private static final int MODE_4 = 3;		
	
	// light (11) on
	private static final int MODE_5 = 4;
	
	// light (12) off
	private static final int MODE_6 = 5;

	// light (12) on
	private static final int MODE_7 = 6;

	// light (13) off
	private static final int MODE_8 = 7;

	// light (13) on
	private static final int MODE_9 = 8;

		
	private int tagid;
	private int location;

	public F7LightService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_16, UtasLightFunction.OFF)) {
				process.controlDevice(Packet7FCollection.lighting16(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_16, UtasLightFunction.ON)) {
				process.controlDevice(Packet7FCollection.lighting16(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_17, UtasLightFunction.OFF)) {
				process.controlDevice(Packet7FCollection.lighting17(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_17, UtasLightFunction.ON)) {
				process.controlDevice(Packet7FCollection.lighting17(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
			if(!process.is7FAllPPL()) {
//				if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_18, UtasLightFunction.OFF)) {
					process.controlDevice(Packet7FCollection.lighting18(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//				}	
			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_18, UtasLightFunction.ON)) {
				process.controlDevice(Packet7FCollection.lighting18(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_8:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_19, UtasLightFunction.OFF)) {
				process.controlDevice(Packet7FCollection.lighting19(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_9:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_19, UtasLightFunction.ON)) {
				process.controlDevice(Packet7FCollection.lighting19(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
