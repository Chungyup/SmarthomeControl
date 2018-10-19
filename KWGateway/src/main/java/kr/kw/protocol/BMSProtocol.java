package kr.kw.protocol;

import java.util.List;

import kr.kw.device.SHSensor;
import kr.kw.device.SHHomeAppliance;
import kr.kw.gateway.KWGateway;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.DeviceName;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.Gateway;
import re.kr.keti.shprotocol.item.HomeAppliance;
import re.kr.keti.shprotocol.item.Sensor;

public class BMSProtocol {

	public static String resGateway(Gateway gw) {
		KMessage res =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.RETREIVE,
				Content.GATEWAY,
				ContentType.JSON,
				gw);
		
		return res.getJSONMessage();
	}
	
	public static String resHAList() {
		List<SHHomeAppliance> haList = WorkingMemory.getInstance().getHAManager().getHomeAppliances();
		KMessage res =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.RETREIVE,
				Content.HOMEAPPLIANCE,
				ContentType.JSON_LIST,
				haList);
		
		return res.getJSONMessage();
	}
	
	public static String resSensorList() {
		List<SHSensor> sensorList = WorkingMemory.getInstance().getSensorManager().getSensors();
		KMessage res =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.RETREIVE,
				Content.SENSOR,
				ContentType.JSON_LIST,
				sensorList);
		
		return res.getJSONMessage();
	}
	
	public static String notiHA(HomeAppliance ha) {
		KMessage noti =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.HOMEAPPLIANCE,
				ContentType.JSON,
				ha);
		
		return noti.getJSONMessage();
	}
	
	public static String notiSensor(Sensor sensor) {
		KMessage noti =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.SENSOR,
				ContentType.JSON,
				sensor);
		
		return noti.getJSONMessage();
	}
	
	public static String emerUpdate(Sensor sensor) {
		KMessage emergency =  new KMessage(
				DeviceName.BMS,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.EMERGENCY,
				Commend.UPDATE,
				Content.SENSOR,
				ContentType.JSON,
				sensor);
		
		return emergency.getJSONMessage();
	}
}
