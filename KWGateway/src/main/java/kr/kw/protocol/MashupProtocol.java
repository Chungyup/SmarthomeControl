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
import re.kr.keti.shprotocol.item.Service;

public class MashupProtocol {
	public static String reqService() {
		KMessage req =  new KMessage(
				DeviceName.MASHUP,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.REQUEST,
				Commend.RETREIVE,
				Content.SERVICE,
				ContentType.NONE,
				null);
		
		return req.getJSONMessage();
	}
	
	public static String reqRegisterHA(HomeAppliance ha) {
		KMessage req =  new KMessage(
				DeviceName.MASHUP,
				DeviceName.HOME_MONITORING,
				KWGateway.ID,
				MessageType.REQUEST,
				Commend.CREATE,
				Content.HOMEAPPLIANCE,
				ContentType.JSON,
				ha);

		return req.getJSONMessage();
	}
	
	public static String register(List<Service> services) {
		KMessage req =  new KMessage(
				DeviceName.MASHUP,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.REQUEST,
				Commend.CREATE,
				Content.SERVICE,
				ContentType.JSON_LIST,
				services);
		
		return req.getJSONMessage();
	}
	
	public static String register(Service service) {
		KMessage req =  new KMessage(
				DeviceName.MASHUP,
				DeviceName.GATEWAY,
				KWGateway.ID,
				MessageType.REQUEST,
				Commend.CREATE,
				Content.SERVICE,
				ContentType.JSON,
				service);
		
		return req.getJSONMessage();
	}
	
	public static String register(String id) {
		KMessage req =  new KMessage(
				DeviceName.MASHUP,
				DeviceName.GATEWAY,
				id,
				MessageType.REQUEST,
				Commend.CREATE,
				Content.GATEWAY,
				ContentType.NONE,
				null);
		
		return req.getJSONMessage();
	}
}
