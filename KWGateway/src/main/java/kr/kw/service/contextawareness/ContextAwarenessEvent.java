package kr.kw.service.contextawareness;

import java.util.Arrays;
import java.util.List;

import kr.kw.service.contextawareness.arff.ARFF;
import kr.kw.service.contextawareness.arff.HomeARFF;
import kr.kw.user.GWUser;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;

public class ContextAwarenessEvent {
	private static final int EVENT_LOCATION = MaxforDeviceGroup.LOCATION;
	private static final int EVENT_SENSOR = MaxforDeviceGroup.PRESSURE;
	
	private static final List<Integer> EVENT_EMERGENCY = Arrays.asList(
			MaxforDeviceGroup.SMARTBAND,
			MaxforDeviceGroup.SCREAM_DECTECTOR);
	
	private static final int EVENT_SCREEN = MaxforDeviceGroup.LOCATION;
	
	public boolean cause(int sensor, GWUser user) {
		switch(sensor) {
		case EVENT_LOCATION:
			return user != null;
		}
		
		return false;
	}
	
	public ARFF cause(int sensor) {
		switch(sensor) {
		case EVENT_SENSOR:
			return HomeARFF.SLEEPWAKEUP;
		}
		
		return null;
	}
	
	public boolean emergency(int sensor) {
		for(int e : EVENT_EMERGENCY) {
			if(sensor == e) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean screen(int sensor) {
		return EVENT_SCREEN == sensor;
	}
}
