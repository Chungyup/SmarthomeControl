package kr.kw.service.floor5;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet5FCollection;

public class F5DoorlockService extends Floor5Relation {

	// door lock 03 off 
	private static final int MODE_2 = 1;		
	
	// door lock 03 on
	private static final int MODE_3 = 2;		
	
	// door lock 04 off
	private static final int MODE_4 = 3;		
	
	// door lock 04 on
	private static final int MODE_5 = 4;

	private int tagid;
	private int location;

	public F5DoorlockService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_3, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.doorlock3(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_3, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.doorlock3(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_4, UtasLightFunction.OFF)) {
				process.controlDevice(Packet5FCollection.doorlock4(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_4, UtasLightFunction.ON)) {
				process.controlDevice(Packet5FCollection.doorlock4(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
