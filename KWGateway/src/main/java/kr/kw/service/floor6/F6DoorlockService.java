package kr.kw.service.floor6;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasDoorlockFunction;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet6FCollection;

public class F6DoorlockService extends Floor6Relation {

	// door lock (05) off 
	private static final int MODE_2 = 1;		
	
	// door lock (05) on
	private static final int MODE_3 = 2;		
	
	// door lock (06) off
	private static final int MODE_4 = 3;		
	
	// door lock (06) on
	private static final int MODE_5 = 4;

	private int tagid;
	private int location;

	public F6DoorlockService(int tagid, int location) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_5, UtasDoorlockFunction.OFF)) {
				process.controlDevice(Packet6FCollection.doorlock5(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_5, UtasDoorlockFunction.ON)) {
				process.controlDevice(Packet6FCollection.doorlock5(UtasDoorlockFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_6, UtasDoorlockFunction.OFF)) {
				process.controlDevice(Packet6FCollection.doorlock6(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_6, UtasDoorlockFunction.ON)) {
				process.controlDevice(Packet6FCollection.doorlock6(UtasDoorlockFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
