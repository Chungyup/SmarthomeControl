package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.shprotocol.item.Smartband;

public class MaxforSmartBand extends Smartband implements SensorState {
	public static final int FALL_DETECT = 2;
	
	public MaxforSmartBand(Smartband band) {
		super(band);
	}
	
	public void updateSensorState(Byte[] payload) {
		// TODO Auto-generated method stub
	
	}

	public String getStateList() {
		// TODO Auto-generated method stub
		return "step=" + getStep() + ",kcal=" + getKcal() + ",btemp=" + getBtemp()
		+ ",fdet=" + getFdet() + ",hrate=" + getHrate() + ",state=" + getState();
	}

	public String getManuf() {
		// TODO Auto-generated method stub
		return Manufacturer.MAXFOR;
	}

	@Override
	public String toString() {
		return "step=" + getStep() + ",kcal=" + getKcal() + ",btemp=" + getBtemp()
				+ ",fdet=" + getFdet() + ",hrate=" + getHrate() + ",state=" + getState();
	}
}
