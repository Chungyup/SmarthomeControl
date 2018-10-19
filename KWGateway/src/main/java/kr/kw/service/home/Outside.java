package kr.kw.service.home;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasACAndHeaterFunction;
import re.kr.keti.lcy.device.utas.function.UtasAircleanerFunction;
import re.kr.keti.lcy.device.utas.function.UtasAirconditionFunction;
import re.kr.keti.lcy.device.utas.function.UtasAudioFunction;
import re.kr.keti.lcy.device.utas.function.UtasBlindFunction;
import re.kr.keti.lcy.device.utas.function.UtasDVDFunction;
import re.kr.keti.lcy.device.utas.function.UtasDehumidifierFunction;
import re.kr.keti.lcy.device.utas.function.UtasDimmingFunction;
import re.kr.keti.lcy.device.utas.function.UtasDoorlockFunction;
import re.kr.keti.lcy.device.utas.function.UtasHeaterFunction;
import re.kr.keti.lcy.device.utas.function.UtasHumidifierFunction;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.function.UtasRS232TVFunction;
import re.kr.keti.lcy.device.utas.function.UtasRobotvacuumFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.PacketSHCollection;

public class Outside extends HomeRelation {

	private static final int MODE_ON = 1;	// all device off, robot vacuum on
	
	private int prelocation;
	private int location1;
	private int location2;
	private int location3;
	
	public Outside(int prelocation, int location1, int location2, int location3) {
		this.prelocation = prelocation;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
	}
	
	@Override
	public double[] getInstances() {
		double[] instances = new double[7];
		instances[0] = getLocation(prelocation);
		instances[1] = getLocation(location1);
		instances[2] = getLocation(location2);
		instances[3] = getLocation(location3);
		instances[4] = getDatePosition();
		instances[5] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		switch(predict) {
		case MODE_ON:
			if(!haMgr.equalOnOff(UtasDeviceType.TV, UtasDeviceNo.NO_4, UtasRS232TVFunction.OFF)) {
				process.controlDevice(PacketSHCollection.tv4(UtasRS232TVFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.AIRCONDITION, UtasDeviceNo.NO_1, UtasAirconditionFunction.OFF)) {
				process.controlDevice(PacketSHCollection.ac1(UtasAirconditionFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_1, UtasACAndHeaterFunction.OFF)) {
				process.controlDevice(PacketSHCollection.acandheater1(UtasACAndHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.BLIND, UtasDeviceNo.NO_3, UtasBlindFunction.OFF)) {
				process.controlDevice(PacketSHCollection.blind3(UtasBlindFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.HEATER, UtasDeviceNo.NO_1, UtasHeaterFunction.OFF)) {
				process.controlDevice(PacketSHCollection.heater1(UtasHeaterFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DVD, UtasDeviceNo.NO_1, UtasDVDFunction.OFF)) {
				process.controlDevice(PacketSHCollection.dvd1(UtasDVDFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.AIRCLEANER, UtasDeviceNo.NO_1, UtasAircleanerFunction.OFF)) {
				process.controlDevice(PacketSHCollection.aircleaner1(UtasAircleanerFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.AUDIO, UtasDeviceNo.NO_1, UtasAudioFunction.OFF)) {
				process.controlDevice(PacketSHCollection.audio1(UtasAudioFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.HUMIDIFIER, UtasDeviceNo.NO_1, UtasHumidifierFunction.OFF)) {
				process.controlDevice(PacketSHCollection.humidifier1(UtasHumidifierFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
//			if(!haMgr.equalOnOff(UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_1, UtasDoorlockFunction.OFF)) {
				process.controlDevice(PacketSHCollection.doorlock1(UtasDoorlockFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
//			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DEHUMIDIFIER, UtasDeviceNo.NO_1, UtasDehumidifierFunction.OFF)) {
				process.controlDevice(PacketSHCollection.dehumidifier1(UtasDehumidifierFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_2, UtasLightFunction.OFF)) {
				process.controlDevice(PacketSHCollection.lighting2(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_1, UtasDimmingFunction.DIM_0)) {
				process.controlDevice(PacketSHCollection.dimming1(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_3, UtasDimmingFunction.DIM_0)) {
				process.controlDevice(PacketSHCollection.dimming3(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_4, UtasDimmingFunction.DIM_0)) {
				process.controlDevice(PacketSHCollection.dimming4(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.DIMMING, UtasDeviceNo.NO_5, UtasDimmingFunction.DIM_0)) {
				process.controlDevice(PacketSHCollection.dimming5(UtasDimmingFunction.DIM_0), UtasPacketTimer.INTERVAL_CTR);
			}
			
			if(!haMgr.equalOnOff(UtasDeviceType.ROBOTVACUUM, UtasDeviceNo.NO_1, UtasRobotvacuumFunction.START)) {
				process.controlDevice(PacketSHCollection.robotvacuum1(UtasRobotvacuumFunction.START), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}

}
