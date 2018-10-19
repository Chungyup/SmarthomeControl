package kr.kw.service.floor7;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasACAndHeaterFunction;
import re.kr.keti.lcy.device.utas.function.UtasAirconditionFunction;
import re.kr.keti.lcy.device.utas.function.UtasPCFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet7FCollection;

public class F7HAService extends Floor7Relation {

	// AC and heater (07) off
	private static final int MODE_2 = 1;		
	
	// AC and heater (07) on
	private static final int MODE_3 = 2;		
	
	// AC and heater (08) off
	private static final int MODE_4 = 3;		
	
	// AC and heater (08) on
	private static final int MODE_5 = 4;
	
	// AC (02) off
	private static final int MODE_6 = 5;
	
	// AC (02) on
	private static final int MODE_7 = 6;

	// PC (07) off
	private static final int MODE_8 = 7;

	// PC (07) on
	private static final int MODE_9 = 8;

	// AC and heater (08) off, PC (07) off
	private static final int MODE_10 = 9;

	// AC and heater (08) on, PC (07) on
	private static final int MODE_11 = 10;

	
	private int tagid;
	private int location;
	private double temperature;

	public F7HAService(int tagid, int location, double temperature) {
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
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_7, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet7FCollection.acandheater7(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_3:
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_7, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet7FCollection.acandheater7(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_4:
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_8, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet7FCollection.acandheater8(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_5:
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_8, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet7FCollection.acandheater8(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_6:
			if(!haMgr.equalOnOff(UtasDeviceType.AIRCONDITION, UtasDeviceNo.NO_2, UtasAirconditionFunction.OFF)) {
				process.controlDevice(Packet7FCollection.ac2(UtasAirconditionFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_7:
			if(!haMgr.equalOnOff(UtasDeviceType.AIRCONDITION, UtasDeviceNo.NO_2, UtasAirconditionFunction.ON)) {
				process.controlDevice(Packet7FCollection.ac2(UtasAirconditionFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_8:
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_7, UtasPCFunction.OFF)) {
				process.controlDevice(Packet7FCollection.pc7(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_9:
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_7, UtasPCFunction.ON)) {
				process.controlDevice(Packet7FCollection.pc7(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
			
		case MODE_10:
			if(!process.is7FAllPPL()) {
				if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_8, UtasACAndHeaterFunction.OFF)) {
					process.controlDevice(Packet7FCollection.acandheater8(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
				}
				
				if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_7, UtasPCFunction.OFF)) {
					process.controlDevice(Packet7FCollection.pc7(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
				}	
			}
			break;
			
		case MODE_11:
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_8, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet7FCollection.acandheater8(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_7, UtasPCFunction.ON)) {
				process.controlDevice(Packet7FCollection.pc7(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}


}
