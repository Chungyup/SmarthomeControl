package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;

public class MaxforScreemDectect implements SensorState {
	public static final int SCREAM_DETECT = 1;
	
	private int type;
	private int value;

	public MaxforScreemDectect(Byte[] state) {
		updateSensorState(state);
	}
	
	public void updateSensorState(Byte[] state) {
		type =  state[0];
		value = state[1];
	}
	
	public int getType() {
		return type;
	}
	
	public int getValue() {
		return value;
	}

	public String getStateList() {
		return "type=" + type + ",value=" + value;
	}
	
	public String getManuf() {
		return Manufacturer.MAXFOR;
	}
	
	@Override
	public String toString() {
		return "type=" + type + " ,value=" + value;
	}
}
