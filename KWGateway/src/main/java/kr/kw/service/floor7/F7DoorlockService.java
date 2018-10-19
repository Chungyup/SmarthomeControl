package kr.kw.service.floor7;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasDoorlockFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet7FCollection;

public class F7DoorlockService extends Floor7Relation {

	// door lock (07) off 
	private static final int MODE_2 = 1;		
	
	// door lock (07) on
	private static final int MODE_3 = 2;		
	
	// door lock (08) off
	private static final int MODE_4 = 3;		
	
	// door lock (08) on
	private static final int MODE_5 = 4;

	// door lock (09) off
	private static final int MODE_6 = 5;		
	
	// door lock (09) on
	private static final int MODE_7 = 6;

	
	private int tagid;
	private int location;

	public F7DoorlockService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_7, UtasDoorlockFunction.OFF)) {
				process.controlDevice(Packet7FCollection.doorlock7(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_7, UtasDoorlockFunction.ON)) {
				process.controlDevice(Packet7FCollection.doorlock7(UtasDoorlockFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_8, UtasDoorlockFunction.OFF)) {
				process.controlDevice(Packet7FCollection.doorlock8(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_8, UtasDoorlockFunction.ON)) {
				process.controlDevice(Packet7FCollection.doorlock8(UtasDoorlockFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
			if(!process.is7FAllPPL()) {
//				if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_9, UtasDoorlockFunction.OFF)) {
					process.controlDevice(Packet7FCollection.doorlock9(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//				}	
			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_9, UtasDoorlockFunction.ON)) {
				process.controlDevice(Packet7FCollection.doorlock9(UtasDoorlockFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
