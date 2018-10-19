package re.kr.keti.lcy.device.utas.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.utas.function.UtasDimmingFunction;

public class UtasDimming implements HAFunction {
	private int dim;
	
	private int func;
	
	public void updateFunction(int func) {
		this.func = func;
		switch (func) {
		case UtasDimmingFunction.DIM_0:
			dim = 0;
			break;
		case UtasDimmingFunction.DIM_40:
			dim = 40;
			break;
		case UtasDimmingFunction.DIM_50:
			dim = 50;
			break;
		case UtasDimmingFunction.DIM_70:
			dim = 70;
			break;
		case UtasDimmingFunction.DIM_100:
			dim = 100;
			break;
		}
	}

	public String getFunctionList() {
		return "dim=" + dim;
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
		return dim == func;
	}
	
	public int getOnOff() {
		// TODO Auto-generated method stub
		return dim;
	}

	public void updateSpecial(int special) {
		// TODO Auto-generated method stub
		
	}

}
