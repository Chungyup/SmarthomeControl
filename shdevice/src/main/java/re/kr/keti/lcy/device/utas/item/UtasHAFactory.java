package re.kr.keti.lcy.device.utas.item;

import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.skuniv.item.SKUnivWashingMachine;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;

public class UtasHAFactory {
	
	public static HAFunction makeHAFunction(int device) {
		switch (device) {
		case UtasDeviceType.TV:
			return new UtasRS232TV();

		case UtasDeviceType.AIRCONDITION:
			return new UtasAircondition();

		case UtasDeviceType.BLIND:
			return new UtasBlind();
	
		case UtasDeviceType.AC_AND_HEATER:
			return new UtasChilerHeater();

		case UtasDeviceType.HEATER:
			return new UtasHeater();

		case UtasDeviceType.DVD:
			return new UtasDVD();
			
		case UtasDeviceType.AIRCLEANER:
			return new UtasAircleaner();

		case UtasDeviceType.ROBOTVACUUM:
			return new UtasRobotvacuum();

		case UtasDeviceType.AUDIO:
			return new UtasAudio();

		case UtasDeviceType.HUMIDIFIER:
			return new UtasHumidifier();

		case UtasDeviceType.DOORLOCK:
			return new UtasDoorlock();

		case UtasDeviceType.DEHUMIDIFIER:
			return new UtasDehumidifier();

		case UtasDeviceType.LIGHT:
			return new UtasLight();
		
		case UtasDeviceType.DIMMING:
			return new UtasDimming();
			
		case UtasDeviceType.PC:
			return new UtasPC();
			
		case UtasDeviceType.WASHINGMACHE:
			return new SKUnivWashingMachine();
		}

		return null;
	}
}
