package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacket;

public class MaxforSensorStateFactory {
	public static SensorState makeSensor(MaxforPacket packet) {
		switch(packet.getDeviceGroup()) {
		// Maxfor
		case MaxforDeviceGroup.INTEGRATION:
			return new MaxforIntegSensor(packet.getPayload());
		case MaxforDeviceGroup.ENVIRONMENT:
			return new MaxforEnvSensor(packet.getPayload());
		case MaxforDeviceGroup.LOCATION:
			return new MaxforLocationTag(packet.getDeviceId(), packet.getPayload());
		case MaxforDeviceGroup.PRESSURE:
			return new MaxforBedPressure(packet.getPayload());
		case MaxforDeviceGroup.SCREAM_DECTECTOR:
			return new MaxforScreemDectect(packet.getPayload());
		}
		return null;
	}
}
