package re.kr.keti.lcy.device.utas.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.utas.function.UtasTVFunction;

public class UtasTV implements HAFunction {
	private int channel;

	private int func;
	private int onOff = -1;
	public void updateFunction(int func) {
		this.func = func;
		switch (func) {
		case UtasTVFunction.ON:
		case UtasTVFunction.OFF:
			onOff = func;
			break;
		case UtasTVFunction.CHANNEL_UP:
			channel++;
			break;

		case UtasTVFunction.CHANNEL_DOWN:
			channel--;
			break;
		}
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getFunctionList() {
		return "onOff=" + onOff + ",channel=" + channel;
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