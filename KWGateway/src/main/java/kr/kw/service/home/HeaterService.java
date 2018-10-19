package kr.kw.service.home;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasHeaterFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.PacketSHCollection;

public class HeaterService extends HomeRelation {
	// heater on
	private static final int MODE_2 = 1;		
	
	// heater off
	private static final int MODE_3 = 2;		
	
	// heater turn
	private static final int MODE_4 = 3;		
	
	// heater strong
	private static final int MODE_5 = 4;
	
	// heater weak
	private static final int MODE_6 = 5;
	
	
	private int location1;
	private int location2;
	private int location3;
	private double temperature;

	public HeaterService(int location1, int location2, int location3, double temperature) {
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
		this.temperature = temperature;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[7];
		instances[0] = getLocation(location1);
		instances[1] = getLocation(location2);
		instances[2] = getLocation(location3);
		instances[3] = temperature;
		instances[4] = getDatePosition();
		instances[5] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		// TODO Auto-generated method stub
		switch(predict) {
		case MODE_2:
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.ON)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_3:
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.OFF)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_4:
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.ROTATE)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.ROTATE), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_5:
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.HIGH)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.HIGH), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_6:
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.LOW)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.LOW), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}

}
