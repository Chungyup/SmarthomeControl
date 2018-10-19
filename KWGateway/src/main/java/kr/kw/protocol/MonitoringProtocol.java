package kr.kw.protocol;

import java.util.List;

import kr.kw.gateway.KWGateway;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.DeviceName;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.HomeAppliance;
import re.kr.keti.shprotocol.item.Sensor;
import re.kr.keti.shprotocol.item.Service;
import re.kr.keti.shprotocol.item.Smartphone;

public class MonitoringProtocol {

	public static String notiHA(HomeAppliance ha) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.HOMEAPPLIANCE,
				ContentType.JSON,
				ha);
		
		return noti.getJSONMessage();
	}
	
	public static String notiLoc(Smartphone smartphone) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.SMARTPHONE,
				ContentType.JSON,
				smartphone);
		
		return noti.getJSONMessage();
	}
	
	public static String notiSensor(Sensor sensor) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.SENSOR,
				ContentType.JSON,
				sensor);
		
		return noti.getJSONMessage();
	}
	
	public static String emergency(Sensor sensor) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.EMERGENCY,
				Commend.UPDATE,
				Content.SENSOR,
				ContentType.JSON,
				sensor);
		
		return noti.getJSONMessage();
	}
	
	public static String updateService(Service service) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.SERVICE,
				ContentType.JSON,
				service);
		
		return noti.getJSONMessage();
	}
	
	public static String updateMashup(List<Service> services) {
		KMessage noti =  new KMessage(
				DeviceName.HOME_MONITORING,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.MASHUP,
				ContentType.JSON_LIST,
				services);
		
		return noti.getJSONMessage();
	}
}
