package kr.kw.service.home;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasBlindFunction;
import re.kr.keti.lcy.device.utas.function.UtasDVDFunction;
import re.kr.keti.lcy.device.utas.function.UtasDimmingFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.PacketSHCollection;
import weka.core.Utils;

public class SleepWakeup extends HomeRelation {
	private static final int MODE_ON = 1;	// light on, DVD on, blind on	
	private static final int MODE_OFF = 2;	// light off, DVD off, blind off
	
	private int prelocation;
	private int location1;
	private int location2;
	private int location3;
	private int bedSensor;
	
	public SleepWakeup(int prelocation, int location1, int location2, int location3, int bedSensor) {
		this.prelocation = prelocation;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
		this.bedSensor = bedSensor;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[8];
		instances[0] = getLocation(prelocation);
		instances[1] = getLocation(location1);
		instances[2] = getLocation(location2);
		instances[3] = getLocation(location3);
		instances[4] = getBedSensor();
		instances[5] = getDatePosition();
		instances[6] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		switch(predict) {
		case MODE_ON:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_100)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_100), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.ON)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.ON)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_OFF:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_0)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.OFF)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.OFF)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}
	
	private double getBedSensor() {
		switch(bedSensor) {
		case 0:
			return 0;
		case 1:
			return 1;
		}
		
		return Utils.missingValue();
	}

}
