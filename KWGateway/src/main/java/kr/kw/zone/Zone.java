package kr.kw.zone;

import kr.kw.device.SHSensor;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.lcy.device.maxfor.item.MaxforBedPressure;
import re.kr.keti.lcy.device.maxfor.item.MaxforEnvSensor;
import re.kr.keti.lcy.device.maxfor.item.MaxforIntegSensor;
import re.kr.keti.lcy.device.maxfor.item.MaxforLocationTag;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceID;
import weka.core.Utils;

public class Zone {
	public static double temperature(int location, WorkingMemory wm) {
		SHSensor sensor = null;
		
		switch(location) {
		case MaxforLocationTag.LOCATION_TV_ZONE:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_LIVINGROOM:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM1:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_1);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM2:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_3);
			break;
		case MaxforLocationTag.LOCATION_KITCHEN:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_9);
			break;
		case MaxforLocationTag.LOCATION_ENTRY:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_1F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_7);
			break;
		case MaxforLocationTag.LOCATION_5F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_4);
			break;
		case MaxforLocationTag.LOCATION_6F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.ENVIRONMENT, MaxforDeviceID.ID_5);
			break;
		case MaxforLocationTag.LOCATION_7F_ENTRANCE:
			break;
		case MaxforLocationTag.LOCATION_7F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_6);
			break;
		}
		
		if(sensor != null) {
			if(sensor.getSst() == MaxforDeviceGroup.INTEGRATION) {
				MaxforIntegSensor integ = (MaxforIntegSensor) sensor.getState();
				return integ.getTemperature();
			} else if(sensor.getSst() == MaxforDeviceGroup.ENVIRONMENT) {
				MaxforEnvSensor env = (MaxforEnvSensor) sensor.getState();
				return env.getTemperature();
			}
		}
		
		return Utils.missingValue();
	}
	
	public static double co2(int location, WorkingMemory wm) {
		SHSensor sensor = null;
		
		switch(location) {
		case MaxforLocationTag.LOCATION_TV_ZONE:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_LIVINGROOM:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM1:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_1);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM2:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_3);
			break;
		case MaxforLocationTag.LOCATION_KITCHEN:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_9);
			break;
		case MaxforLocationTag.LOCATION_ENTRY:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_1F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_7);
			break;
		case MaxforLocationTag.LOCATION_7F_ENTRANCE:
			break;
		case MaxforLocationTag.LOCATION_7F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_6);
			break;
		}
		
		if(sensor != null) {
			if(sensor.getSst() == MaxforDeviceGroup.INTEGRATION) {
				MaxforIntegSensor integ = (MaxforIntegSensor) sensor.getState();
				return integ.getCo2();
			}
		}
		
		return Utils.missingValue();
	}
	
	public static double humidity(int location, WorkingMemory wm) {
		SHSensor sensor = null;
		
		switch(location) {
		case MaxforLocationTag.LOCATION_TV_ZONE:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_LIVINGROOM:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM1:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_1);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM2:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_3);
			break;
		case MaxforLocationTag.LOCATION_KITCHEN:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_9);
			break;
		case MaxforLocationTag.LOCATION_ENTRY:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_1F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_7);
			break;
		case MaxforLocationTag.LOCATION_6F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.ENVIRONMENT, MaxforDeviceID.ID_5);
			break;
		case MaxforLocationTag.LOCATION_7F_ENTRANCE:
			break;
		case MaxforLocationTag.LOCATION_7F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_6);
			break;
		}
		
		if(sensor != null) {
			if(sensor.getSst() == MaxforDeviceGroup.INTEGRATION) {
				MaxforIntegSensor integ = (MaxforIntegSensor) sensor.getState();
				return integ.getHumidity();
			} else if(sensor.getSst() == MaxforDeviceGroup.ENVIRONMENT) {
				MaxforEnvSensor env = (MaxforEnvSensor) sensor.getState();
				return env.getHumidity();
			}
		}
		
		return Utils.missingValue();
	}
	
	public static double illumination(int location, WorkingMemory wm) {
		SHSensor sensor = null;
		
		switch(location) {
		case MaxforLocationTag.LOCATION_TV_ZONE:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_LIVINGROOM:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM1:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_1);
			break;
		case MaxforLocationTag.LOCATION_BEDROOM2:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_3);
			break;
		case MaxforLocationTag.LOCATION_KITCHEN:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_9);
			break;
		case MaxforLocationTag.LOCATION_ENTRY:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_2);
			break;
		case MaxforLocationTag.LOCATION_1F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_7);
			break;
		case MaxforLocationTag.LOCATION_7F_ENTRANCE:
			break;
		case MaxforLocationTag.LOCATION_7F:
			sensor = wm.getSensorManager().getSensor(MaxforDeviceGroup.INTEGRATION, MaxforDeviceID.ID_6);
			break;
		}
		
		if(sensor != null) {
			if(sensor.getSst() == MaxforDeviceGroup.INTEGRATION) {
				MaxforIntegSensor integ = (MaxforIntegSensor) sensor.getState();
				return integ.getIllumination();
			}
		}
		
		return Utils.missingValue();
	}
	
	public static int pressure(WorkingMemory wm) {
		MaxforBedPressure pressure = (MaxforBedPressure) WorkingMemory.getInstance().getSensorManager().getState(MaxforDeviceGroup.PRESSURE, MaxforDeviceID.ID_1);
		int value = -1;
		if(pressure != null) {
			value = pressure.getValue();
		}
		
		return value;
	}
}
