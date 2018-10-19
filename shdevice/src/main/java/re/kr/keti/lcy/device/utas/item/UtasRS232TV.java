package re.kr.keti.lcy.device.utas.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.utas.function.UtasRS232TVFunction;

public class UtasRS232TV implements HAFunction {
	private int channel;

	private int func;
	
	private int onOff = -1;
	
	public void updateFunction(int func) {
		this.func = func;
		switch (func) {
		case UtasRS232TVFunction.ON:
		case UtasRS232TVFunction.OFF:
			onOff = func;
			break;
			
		case UtasRS232TVFunction.CHANNEL_1:
			channel = 1;
			break;

		case UtasRS232TVFunction.CHANNEL_2:
			channel = 2;
			break;
			
		case UtasRS232TVFunction.CHANNEL_3:
			channel = 3;
			break;
			
		case UtasRS232TVFunction.CHANNEL_4:
			channel = 4;
			break;
			
		case UtasRS232TVFunction.CHANNEL_5:
			channel = 5;
			break;
			
		case UtasRS232TVFunction.CHANNEL_6:
			channel = 6;
			break;
			
		case UtasRS232TVFunction.CHANNEL_7:
			channel = 7;
			break;
			
		case UtasRS232TVFunction.CHANNEL_8:
			channel = 8;
			break;
			
		case UtasRS232TVFunction.CHANNEL_9:
			channel = 9;
			break;
			
		case UtasRS232TVFunction.CHANNEL_10:
			channel = 10;
			break;
			
		case UtasRS232TVFunction.CHANNEL_11:
			channel = 11;
			break;
			
		case UtasRS232TVFunction.CHANNEL_12:
			channel = 12;
			break;
			
		case UtasRS232TVFunction.CHANNEL_13:
			channel = 13;
			break;
			
		case UtasRS232TVFunction.CHANNEL_14:
			channel = 14;
			break;
			
		case UtasRS232TVFunction.CHANNEL_15:
			channel = 15;
			break;
			
		case UtasRS232TVFunction.CHANNEL_16:
			channel = 16;
			break;
			
		case UtasRS232TVFunction.CHANNEL_17:
			channel = 17;
			break;
			
		case UtasRS232TVFunction.CHANNEL_18:
			channel = 18;
			break;
			
		case UtasRS232TVFunction.CHANNEL_19:
			channel = 19;
			break;
			
		case UtasRS232TVFunction.CHANNEL_20:
			channel = 20;
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