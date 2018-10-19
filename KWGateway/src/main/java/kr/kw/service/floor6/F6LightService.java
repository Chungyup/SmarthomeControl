package kr.kw.service.floor6;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet6FCollection;

public class F6LightService extends Floor6Relation {

	// light (0D) off
	private static final int MODE_2 = 1;		
	
	// light (0D) on
	private static final int MODE_3 = 2;		
	
	// light (0E) off
	private static final int MODE_4 = 3;		
	
	// light (0E) on
	private static final int MODE_5 = 4;
	
	// light (0F) off
	private static final int MODE_6 = 5;

	// light (0F) on
	private static final int MODE_7 = 6;

		
	private int tagid;
	private int location;

	public F6LightService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_13, UtasLightFunction.OFF)) {
				process.controlDevice(Packet6FCollection.lighting13(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_13, UtasLightFunction.ON)) {
				process.controlDevice(Packet6FCollection.lighting13(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_14, UtasLightFunction.OFF)) {
				process.controlDevice(Packet6FCollection.lighting14(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_14, UtasLightFunction.ON)) {
				process.controlDevice(Packet6FCollection.lighting14(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_15, UtasLightFunction.OFF)) {
				process.controlDevice(Packet6FCollection.lighting15(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_15, UtasLightFunction.ON)) {
				process.controlDevice(Packet6FCollection.lighting15(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
