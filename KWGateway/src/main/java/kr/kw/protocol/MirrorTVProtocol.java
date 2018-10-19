package kr.kw.protocol;

import java.util.List;

import kr.kw.gateway.KWGateway;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.DeviceName;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.Schedule;
import re.kr.keti.shprotocol.item.Sensor;
import re.kr.keti.shprotocol.item.Smartphone;

public class MirrorTVProtocol {

	public static String resRetrieve(List<Schedule> schedules) {
		KMessage res =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.RETREIVE,
				Content.SCHEDULE,
				ContentType.JSON_LIST,
				schedules);
		
		return res.getJSONMessage();
	}
	
	public static String resCreate(Schedule schedule) {
		KMessage res =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.CREATE,
				Content.SCHEDULE,
				ContentType.JSON,
				schedule);
		
		return res.getJSONMessage();
	}
	
	public static String resDelete(Schedule schedule) {
		KMessage res =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.DELETE,
				Content.SCHEDULE,
				ContentType.JSON,
				schedule);
		
		return res.getJSONMessage();
	}
	
	public static String resRetrieve(Smartphone phone) {
		KMessage res =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.RESPONSE,
				Commend.RETREIVE,
				Content.SMARTPHONE,
				ContentType.JSON,
				phone);
		
		return res.getJSONMessage();
	}
	
	public static String emerUpdate(Sensor sensor) {
		KMessage res =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.EMERGENCY,
				Commend.UPDATE,
				Content.SENSOR,
				ContentType.JSON,
				sensor);
		
		return res.getJSONMessage();
	}
	
	public static String notiUpdate(int brtn) {
		KMessage noti =  new KMessage(
				DeviceName.MIRROR_TV,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.NOTI,
				Commend.UPDATE,
				Content.MIRRORTV,
				ContentType.JSON,
				brtn);
		
		return noti.getJSONMessage();
	}
}
