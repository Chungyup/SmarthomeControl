package kr.kw.connect.receiver;

import java.util.List;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.gateway.KWGateway;
import kr.kw.protocol.MashupProtocol;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.WorkingMemory;
import kr.re.keti.socket.IKETIClientReceiver;
import kr.re.keti.socket.KETISockError;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.item.Service;

public class MashupReceiver implements IKETIClientReceiver {
	private static final String TAG = "MashupReceiver";

	private GWProcess process;

	public MashupReceiver(GWProcess process) {
		this.process = process;
	}

	public void receiveString(String message) {
		KWLOG.debug(TAG, message);
//		KMessage msg = KMessage.getMessage(message);
//		if (msg.getCt() == Content.M_SERVICE) {
//			List<Service> services = msg.getServiceList();
////			MashupService ms = MashupProtocol.makeMashupService(msg.getData());
//			process.send(new Post(To.MONITORING, 
//					MonitoringProtocol.notiService(services)));
//		}
		
		KMessage msg = KMessage.getMessage(message);
		if(msg.getCt() == Content.MASHUP && msg.getCtt() == ContentType.JSON_LIST) {
			switch(msg.getCmd()) {
			case Commend.UPDATE:
				List<Service> services = msg.getServiceList();
				process.updateMashup(services);
				break;
			}
		}
	}

	public void receiveByte(byte[] packet, int length) {
		// TODO Auto-generated method stub
		
	}

	public void onConnected(String message) {
		KWLOG.debug(TAG, message);
		process.send(new Post(To.MASHUP, MashupProtocol.register(KWGateway.ID)));
		
		process.send(new Post(To.MASHUP, MashupProtocol.register(
				WorkingMemory.getInstance().getServiceManager().getServices())));
	}

	public void onDisconnected(String messagae) {
		// TODO Auto-generated method stub

	}

	public void onError(int id, String message) {
		KWLOG.debug(TAG, "err: " + message);
		
		switch(id) {
		case KETISockError.ERR_CONNECT:
		case KETISockError.ERR_DISCONNECT:
		case KETISockError.ERR_INPUT:
		case KETISockError.ERR_OUTPUT:
			// try to reconnect
			process.reconnect(To.MASHUP);
		}
	}

	public void uploadFile(String file) {
	}

}
