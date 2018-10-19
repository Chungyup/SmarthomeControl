package re.kr.keti.lcy.device.utas.packet;

public class UtasDeviceName {
	public static String get(int type) {
		switch(type) {
		case UtasDeviceType.AC_AND_HEATER:
			return "ac_and_heater";
		case UtasDeviceType.AIRCLEANER:
			return "aircleaner";
		case UtasDeviceType.AIRCONDITION:
			return "aircondition";
		case UtasDeviceType.AUDIO:
			return "audio";
		case UtasDeviceType.BLIND:
			return "blind";
		case UtasDeviceType.DEHUMIDIFIER:
			return "dehumudifier";
		case UtasDeviceType.DOORLOCK:
			return "doorlock";
		case UtasDeviceType.DVD:
			return "dvb";
		case UtasDeviceType.HEATER:
			return "heater";
		case UtasDeviceType.HUMIDIFIER:
			return "humidifier";
		case UtasDeviceType.LIGHT:
			return "light";
		case UtasDeviceType.PC:
			return "pc";
		case UtasDeviceType.ROBOTVACUUM:
			return "robotvacuum";
		case UtasDeviceType.TV:
			return "tv";
		case UtasDeviceType.DIMMING:
			return "dimming";
		case UtasDeviceType.WASHINGMACHE:
			return "washingmache";
		}
		
		return "";
	}
}
