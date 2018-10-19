package re.kr.keti.lcy.device.skuniv.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.utas.function.UtasAircleanerFunction;

public class SKUnivWashingMachine implements HAFunction {

	private int func;
	private int onOff;
	private int user;
	
	public void updateFunction(int func) {
		this.func = func;
		switch(func) {
		case UtasAircleanerFunction.ON:
		case UtasAircleanerFunction.OFF:
			onOff = func;
			break;
		}
	}

	public String getFunctionList() {
		// TODO Auto-generated method stub
		return "onOff=" + onOff + ",user=" + user;
	}

	public int getFunction() {
		// TODO Auto-generated method stub
		return func;
	}
	
	public int getSpecial() {
		// TODO Auto-generated method stub
		return user;
	}

	public String getManuf() {
		// TODO Auto-generated method stub
		return Manufacturer.SK_UNIV;
	}

	public boolean equalOnOff(int func) {
		// TODO Auto-generated method stub
		return onOff == func;
	}

	public int getOnOff() {
		// TODO Auto-generated method stub
		return onOff;
	}

	public void updateSpecial(int special) {
		user = special;
	}


}
