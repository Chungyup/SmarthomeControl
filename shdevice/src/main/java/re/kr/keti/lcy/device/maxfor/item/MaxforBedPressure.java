package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.util.Utils;

public class MaxforBedPressure implements SensorState {
	private int value;
	
	public MaxforBedPressure(Byte[] state) {
		updateSensorState(state);
	}

	public void updateSensorState(Byte[] state) {
		value = Utils.makeByteArraytoInt(state[0], state[1]);
	}

//	@Override
//	public String toString() {
//		return "MaxforBedPressure [value=" + value + "]";
//	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "value=" + value;
	}

	public String getStateList() {
		return "value=" + value;
	}

	
	public String getManuf() {
		return Manufacturer.MAXFOR;
	}
}