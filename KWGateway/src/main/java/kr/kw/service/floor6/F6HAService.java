package kr.kw.service.floor6;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasACAndHeaterFunction;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet6FCollection;

public class F6HAService extends Floor6Relation {

	// air condition 1 off
	private static final int MODE_2 = 1;		
	
	// air condition 1 on
	private static final int MODE_3 = 2;		
	
	// air condition 2 off
	private static final int MODE_4 = 3;		
	
	// air condition 2 on
	private static final int MODE_5 = 4;
	
	private int tagid;
	private int location;
	private double temperature;

	public F6HAService(int tagid, int location, double temperature) {
		this.tagid = tagid;
		this.location = location;
		this.temperature = temperature;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[6];
		instances[0] = getTagIdPosition(tagid);
		instances[1] = getLocation(location);
		instances[2] = temperature;
		instances[3] = getDatePosition();
		instances[4] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		// TODO Auto-generated method stub
		switch(predict) {
		case MODE_2:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_5, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet6FCollection.acandheater5(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_5, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet6FCollection.acandheater5(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_6, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet6FCollection.acandheater6(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_6, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet6FCollection.acandheater6(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		}
	}

}
