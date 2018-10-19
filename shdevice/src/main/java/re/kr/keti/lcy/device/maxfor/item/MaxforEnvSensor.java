package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.util.Utils;

public class MaxforEnvSensor  implements SensorState  {
	private double temperature;
	private double humidity;
	private double co2;
	
	public MaxforEnvSensor(Byte[] state) {
		updateSensorState(state);
	}
	
	public void updateSensorState(Byte[] state) {
		int rawTemp = Utils.makeByteArraytoInt(state[0], state[1]);
		temperature = calculateTemp(rawTemp);
		
		int rawHumd = Utils.makeByteArraytoInt(state[2], state[3]);
		humidity = calculateHumd(rawHumd);
		
		int rawCo2 = Utils.makeByteArraytoInt(state[4], state[5]);
		co2 = calculateCo2(rawCo2);
	}
	
	private double calculateTemp(int rawTemp) {
		return rawTemp * 0.01 - 39.6;
	}
	
	private double calculateHumd(int rawHumd) {
		return -2.0468 + 0.0367 * rawHumd +(-1.5955 * 0.000001) * rawHumd * rawHumd;
	}
	
	private double calculateCo2(int rawCo2) {
		return rawCo2 * 3300 / 16384;
	}

	public String getStateList() {
		return "temperature=" + temperature + ",humidity=" + humidity + ",co2=" + co2;
	}
	
	public String getManuf() {
		return Manufacturer.MAXFOR;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	@Override
	public String toString() {
		return "temperature=" + temperature + " ,humidity=" + humidity + " ,co2=" + co2;
	}

}
