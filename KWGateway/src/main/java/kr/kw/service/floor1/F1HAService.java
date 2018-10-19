package kr.kw.service.floor1;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasACAndHeaterFunction;
import re.kr.keti.lcy.device.utas.function.UtasPCFunction;
import re.kr.keti.lcy.device.utas.function.UtasTVFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.Packet1FCollection;

public class F1HAService extends Floor1Relation {

	// all TV off
	private static final int MODE_2 = 1;		
	
	// all TV on
	private static final int MODE_3 = 2;		
	
	// all PC off
	private static final int MODE_4 = 3;		
	
	// all PC on
	private static final int MODE_5 = 4;
	
	// air condition on
	private static final int MODE_6 = 5;
	
	// air condition off
	private static final int MODE_7 = 6;
	
	// all TV and PC on
	private static final int MODE_8 = 7;

	// all TV and PC on and air condition on
	private static final int MODE_9 = 8;
	
	// all TV and PC off
	private static final int MODE_10 = 9;
	
	// all TV and PC off and air condition off
	private static final int MODE_11 = 10;
	
	private int tagid;
	private int location;
	private double temperature;

	public F1HAService(int tagid, int location, double temperature) {
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
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_5, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv5(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_6, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv6(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_7, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv7(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_8, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv8(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_9, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv9(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_10, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv10(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_11, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv11(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_12, UtasTVFunction.OFF)) {
				process.controlDevice(Packet1FCollection.tv12(UtasTVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_3:			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_5, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv5(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_6, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv6(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_7, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv7(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_8, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv8(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_9, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv9(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_10, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv10(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_11, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv11(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_12, UtasTVFunction.ON)) {
				process.controlDevice(Packet1FCollection.tv12(UtasTVFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_4:
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_1, UtasPCFunction.OFF)) {
				process.controlDevice(Packet1FCollection.pc1(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_2, UtasPCFunction.OFF)) {
				process.controlDevice(Packet1FCollection.pc2(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_3, UtasPCFunction.OFF)) {
				process.controlDevice(Packet1FCollection.pc3(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_4, UtasPCFunction.OFF)) {
				process.controlDevice(Packet1FCollection.pc4(UtasPCFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_5:			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_1, UtasPCFunction.ON)) {
				process.controlDevice(Packet1FCollection.pc1(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_2, UtasPCFunction.ON)) {
				process.controlDevice(Packet1FCollection.pc2(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_3, UtasPCFunction.ON)) {
				process.controlDevice(Packet1FCollection.pc3(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.PC, UtasDeviceNo.NO_4, UtasPCFunction.ON)) {
				process.controlDevice(Packet1FCollection.pc4(UtasPCFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_6:
			
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_2, UtasACAndHeaterFunction.ON)) {
				process.controlDevice(Packet1FCollection.acandheater2(UtasACAndHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_7:
			
//			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_2, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(Packet1FCollection.acandheater2(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			break;
		case MODE_8:
			predict = MODE_3;
			start(process, haMgr);
			predict = MODE_5;
			start(process, haMgr);
			predict = MODE_8;
			break;
		case MODE_9:
			predict = MODE_3;
			start(process, haMgr);
			predict = MODE_5;
			start(process, haMgr);
			predict = MODE_6;
			start(process, haMgr);
			predict = MODE_9;
			break;
		case MODE_10:
			predict = MODE_2;
			start(process, haMgr);
			predict = MODE_4;
			start(process, haMgr);
			predict = MODE_10;
			break;
		case MODE_11:
			predict = MODE_2;
			start(process, haMgr);
			predict = MODE_4;
			start(process, haMgr);
			predict = MODE_7;
			start(process, haMgr);
			predict = MODE_11;
			break;
		}
	}

}
