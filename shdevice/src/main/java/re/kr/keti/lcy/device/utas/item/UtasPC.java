package re.kr.keti.lcy.device.utas.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.utas.function.UtasPCFunction;

public class UtasPC implements HAFunction {
	
	private int func;
	private int onOff = -1;
	public void updateFunction(int func) {
		this.func = func;
		switch (func) {
		case UtasPCFunction.ON:
		case UtasPCFunction.OFF:
			onOff = func;
			break;
		}
	}

	public String getFunctionList() {
		return "onOff=" + onOff;
	}

	public int getFunction() {
		return func;
	}
	
	public int getSpecial() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getManuf() {
		// TODO Auto-generated method stub
		return Manufacturer.UTAS;
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
		// TODO Auto-generated method stub
		
	}
}