package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kw.device.SHSensor;
import kr.kw.util.KWLOG;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.device.maxfor.item.MaxforLocationTag;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;

public class SensorManager {
	private List<SHSensor> maxforSensors;

	public SensorManager() {
		maxforSensors = new ArrayList<SHSensor>();
	}
	
	public SHSensor chageState(SHSensor newss) {
		try {
			int sensorGroup = newss.getSensorGroup();
			int nodeId = newss.getDeviceId();
			
			for(SHSensor ss : maxforSensors) {
				if(ss.same(sensorGroup, nodeId)) {
					ss.setState(newss.getState());
					ss.mapping();
					return ss;
				}
			}
		} catch (NullPointerException e) {
			KWLOG.excep("SensorManager", e.getMessage());
		}
		
		return null;
	}
	
	public SHSensor register(SHSensor sensor) {
		if(sensor != null) {
			sensor.mapping();
			maxforSensors.add(sensor);
			return sensor;
		}
		
		return null;
	}

	public SHSensor getSensor(int sensorGroup, int deviceId) {
		for(SHSensor sensor : maxforSensors) {
			if(sensor.same(sensorGroup, deviceId)) {
				return sensor;
			}
		}
		
		return null;
	}
	
	public SensorState getState(int sensorGroup, int deviceId) {
		for(SHSensor sensor : maxforSensors) {
			if(sensor.same(sensorGroup, deviceId)) {
				return sensor.getState();
			}
		}
		
		return null;
	}
	
	public List<SHSensor> getSensors() {
		return maxforSensors;
	}
	
	
	public Map<Integer, Integer> getUsers() {
		Map<Integer, Integer> tags = new HashMap<Integer, Integer>();
		for(SHSensor sensor : maxforSensors) {
			if(sensor.getSensorGroup() == MaxforDeviceGroup.LOCATION) {
				MaxforLocationTag tag = (MaxforLocationTag) sensor.getState();
				tags.put(tag.getTagId(), tag.getReaderId());
			}
		}
		
		return tags;
	}
	
	@Override
	public String toString() {
		String sensorList = "";
		for (SHSensor sensor : maxforSensors) {
			sensorList += sensor.toString() + "\n\t";
		}
		
		return sensorList;
	}

}
