package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.util.Utils;


/**
 * 
 * PAYLOAD	(total 24bytes)
 * 
 * 	[1 byte: message type]
 *	[1 byte: sensor group]
 * 	[1 byte: number of sensors]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor1 value]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor2 value]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor3 value]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor4 value]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor5 value]
 * 	[1 byte: sensor ID]
 *  [2 bytes: sensor6 value]
 *  [1 byte: status]
 *  [2 bytes: CRC]
 * */
public class MaxforIntegSensor implements SensorState {
/*	
	public static final byte SENSOR_ID_TEMPERATURE = 17;	// 0x11
	public static final byte SENSOR_ID_HUMIDITY = 18;		// 0x12
	public static final byte SENSOR_ID_ILLUMINATION = 19;	// 0x13
	public static final byte SENSOR_ID_CO2 = 20;			// 0x14
	public static final byte SENSOR_ID_PIR = 49;			// 0x31
	public static final byte SENSOR_ID_VOICE_RECOG = 51;	// 0x33
*/	
	
	@SuppressWarnings("unused")
	private int sensorCount;
	
	@SuppressWarnings("unused")
	private int temperatureId;
	private int temperature;
	
	@SuppressWarnings("unused")
	private int humidityId;
	private int humidity;
	
	@SuppressWarnings("unused")
	private int co2Id;
	private int co2;
	
	@SuppressWarnings("unused")
	private int illuminationId;
	private int illumination;
	
	@SuppressWarnings("unused")
	private int pirId;
	private int pir;
	
	@SuppressWarnings("unused")
	private int voiceRecognitionId;
	private int voiceRecognition;
	
	public MaxforIntegSensor(Byte[] item) {
		updateSensorState(item);
	}

	public void updateSensorState(Byte[] state) {
		sensorCount = state[2];
		
		temperatureId = state[3];
		temperature = Utils.makeByteArraytoInt(state[4], state[5]);
		
		humidityId = state[6];
		humidity = Utils.makeByteArraytoInt(state[7], state[8]);
		
		illuminationId = state[9];
		illumination = Utils.makeByteArraytoInt(state[10], state[11]);
		
		co2Id = state[12];
		co2 = Utils.makeByteArraytoInt(state[13], state[14]);
		
		pirId = state[15];
		pir = Utils.makeByteArraytoInt(state[16], state[17]);
		
		voiceRecognitionId = state[18];
		voiceRecognition = Utils.makeByteArraytoInt(state[19], state[20]);
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public int getHumidity() {
		return humidity;
	}
	
	public int getCo2() {
		return co2;
	}
	
	public int getIllumination() {
		return illumination;
	}
	
	public int getPir() {
		return pir;
	}
	
	@Override
	public String toString() {
		return "temperature=" + temperature
				+ " ,humidity=" + humidity + " ,co2=" + co2 + " ,illumination=" + illumination + " ,pir=" + pir
				+ " ,voiceRecognition=" + voiceRecognition;
	}

	public String getStateList() {
		return "temperature=" + temperature
				+ ",humidity=" + humidity + ",co2=" + co2 + ",illumination=" + illumination + ",pir=" + pir
				+ ",voiceRecognition=" + voiceRecognition;
	}
	
	public String getManuf() {
		return Manufacturer.MAXFOR;
	}

}
