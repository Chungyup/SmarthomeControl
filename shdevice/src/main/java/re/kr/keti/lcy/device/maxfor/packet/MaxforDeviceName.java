package re.kr.keti.lcy.device.maxfor.packet;

public class MaxforDeviceName {
	public static String get(int group) {
		switch(group) {
		case MaxforDeviceGroup.ENVIRONMENT:
			return "environment";
		case MaxforDeviceGroup.INTEGRATION:
			return "integration";
		case MaxforDeviceGroup.LOCATION:
			return "location";
		case MaxforDeviceGroup.PRESSURE:
			return "pressure";
		case MaxforDeviceGroup.SCREAM_DECTECTOR:
			return "screamdectector";
		case MaxforDeviceGroup.SMARTBAND:
			return "smartband";
		}
		
		return "";
	}
}
