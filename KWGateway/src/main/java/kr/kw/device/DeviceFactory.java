package kr.kw.device;

import java.util.ArrayList;
import java.util.List;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.device.maxfor.item.MaxforSensorStateFactory;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacket;
import re.kr.keti.lcy.device.utas.item.UtasHAFactory;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class DeviceFactory {
	public static SHHomeAppliance make(final UtasPacket packet) {
		HAFunction function = UtasHAFactory.makeHAFunction(packet.getDevice());
		
		if (function != null) {
			SHHomeAppliance ha = new SHHomeAppliance(
					packet.getDevice(), 
					packet.getDeviceNo(), 
					packet.getZone(), 
					function);
			
//			ha.updateCommonFunction(packet.getFunction());
			ha.getHAFunction().updateFunction(packet.getFunction());
			ha.getHAFunction().updateSpecial(packet.getSpecial());
			
			return ha;
		}
		
		return null;
	}
	
	public static SHSensor make(final MaxforPacket packet) {
		SensorState sensorState = MaxforSensorStateFactory.makeSensor(packet);
		if(sensorState != null) {
			SHSensor sensor = new SHSensor(
					packet.getDeviceGroup(), 
					packet.getDeviceId(), 
					sensorState);
			
			sensor.mapping();

			return sensor;
		}
		
		return null;
	}
	
	public static List<SHSensor> sensorFilter = new ArrayList<SHSensor>();
	public static boolean filterSensor(int group, int id) {
		for(SHSensor s : sensorFilter) {
			if(s.getSensorGroup() == group && s.getDeviceId() == id) {
				return true; 
			}
		}
		
		return false;
	}
}
