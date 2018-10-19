package kr.kw.service.floor5;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasACAndHeaterFunction;
import re.kr.keti.lcy.device.utas.function.UtasPCFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet5FCollection;

public class F5HAService extends Floor5Relation {

	// air condition 2 off
	private static final int MODE_2 = 1;		
	
	// air condition 2 on
	private static final int MODE_3 = 2;		
	
	// air condition 1 off
	private static final int MODE_4 = 3;		
	
	// air condition 1 on
	private static final int MODE_5 = 4;
	
	// all PC off
	private static final int MODE_6 = 5;
	
	// all PC on
	private static final int MODE_7 = 6;
	
	// all PC off, air condition 1 off
	private static final int MODE_8 = 7;

	// all PC on, air condition 1 on
	private static final int MODE_9 = 8;
	
	private int tagid;
	private int location;
	private double temperature;

	public F5HAService(int tagid, int location, double temperature) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_3, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet5FCollection.acandheater3(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_3, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet5FCollection.acandheater3(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_4, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet5FCollection.acandheater4(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_5:
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_4, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet5FCollection.acandheater4(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_6:
//			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_5, UtasPCFunction.OFF)) {
				process.controlDevice(Packet5FCollection.pc5(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
//			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_6, UtasPCFunction.OFF)) {
				process.controlDevice(Packet5FCollection.pc6(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_7:
//			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_5, UtasPCFunction.ON)) {
				process.controlDevice(Packet5FCollection.pc5(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
//			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_6, UtasPCFunction.ON)) {
				process.controlDevice(Packet5FCollection.pc6(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_8:
			predict = MODE_6;
			start(process, haMgr);
			predict = MODE_4;
			start(process, haMgr);
			predict = MODE_8;
			break;
		case MODE_9:
			predict = MODE_7;
			start(process, haMgr);
			predict = MODE_5;
			start(process, haMgr);
			predict = MODE_9;
			break;
		}
	}

}
