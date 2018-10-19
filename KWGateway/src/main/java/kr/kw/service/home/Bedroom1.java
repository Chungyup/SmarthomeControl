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

public class Bedroom1 extends HomeRelation {
	
	private static final int MODE_ON_ENTRANCE = 1;		
	private static final int MODE_OFF_ENTRANCE = 2;
	private static final int MODE_ON_ALREADY_WAKEUP = 3;
	private static final int MODE_OFF_ALREADY_WAKEUP = 4;
	private static final int MODE_PER_ON = 5;	// light on, blind on
	private static final int MODE_PER_OFF = 6;	// light off, blind off
	
	
	private int prelocation;
	private int location1;
	private int location2;
	private int location3;
	private double temperature;
	private double humidity;
	private double co2;
	
	public Bedroom1(int prelocation, int location1, int location2, int location3, double temperature, double humidity,
			double co2) {
		this.prelocation = prelocation;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
		this.temperature = temperature;
		this.humidity = humidity;
		this.co2 = co2;
	}

	@Override
	public double[] getInstances() {
		double[] instances = new double[10];
		instances[0] = getLocation(prelocation);
		instances[1] = getLocation(location1);
		instances[2] = getLocation(location2);
		instances[3] = getLocation(location3);
		instances[4] = temperature;
		instances[5] = humidity;
		instances[6] = co2;
		instances[7] = getDatePosition();
		instances[8] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		switch(predict) {
		case MODE_ON_ENTRANCE:
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.ON)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.ON)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_100)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_100), UtasPacketTimer.INTERVAL_CTR);
			}
			
			break;
		case MODE_OFF_ENTRANCE:
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.OFF)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.OFF)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_0)) {				
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			break;
		case MODE_ON_ALREADY_WAKEUP:
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.ON)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_100)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_100), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_OFF_ALREADY_WAKEUP:
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.OFF)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_0)) {				
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_PER_ON:
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_100)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_100), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.ON)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
			
		case MODE_PER_OFF:
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_0)) {				
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.OFF)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}

}
