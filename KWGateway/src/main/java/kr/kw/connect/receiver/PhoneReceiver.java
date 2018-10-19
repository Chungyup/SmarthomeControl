package kr.kw.connect.receiver;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.device.SHSensor;
import kr.kw.gateway.KWGateway;
import kr.kw.util.KWLOG;
import kr.re.keti.socket.IKETIServerReceiver;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.lcy.device.maxfor.item.MaxforSmartBand;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceID;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.DeviceName;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.IType;
import re.kr.keti.shprotocol.item.Smartphone;

public class PhoneReceiver implements IKETIServerReceiver {
	private static final String TAG = "PhoneReceiver";

	private GWProcess process;

	public PhoneReceiver(GWProcess process) {
		this.process = process;
	}

	public void onAddClient(KETIClient client) {
		KWLOG.info(TAG, "connected: " + client.getHostName());
	}

	public void onDisconnectClient(KETIClient client) {
		KWLOG.info(TAG, "disconnected: " + client.getHostName());
	}

	public void onError(String arg0) {
		// TODO Auto-generated method stub

	}

	public void onGetServerInfo(String arg0) {
		// TODO Auto-generated method stub

	}

	public void onReceiveMsg(KETIClient client, String message) {
		KWLOG.debug(TAG, "message: " + message);

		KMessage msg = KMessage.getMessage(message);
		if (msg.getMt() == MessageType.NOTI) {

			if (msg.getCt() == Content.SMARTPHONE && msg.getCtt() == ContentType.JSON) {
				Smartphone smartphone = msg.getSmartphone();
				process.collect(IType.PHONE, smartphone);
				if(smartphone != null) {
					process.updateLocation(smartphone);	
				}
				
//				msg.setTo(DeviceName.MIRROR_TV);
//				msg.setId(KWGateway.ID);
//				process.send(new Post(To.MIRRORTV, msg.getJSONMessage()));
			}

			else if (msg.getCt() == Content.SMARTBAND && msg.getCtt() == ContentType.JSON) {
				MaxforSmartBand band = new MaxforSmartBand(msg.getSmartband());
				SHSensor sensor = new SHSensor(MaxforDeviceGroup.SMARTBAND, MaxforDeviceID.ID_1, band);
				
				sensor = (SHSensor) process.collect(IType.SENSOR, sensor);
				process.scenario(sensor);
			}
		}
		
		else if(msg.getMt() == MessageType.REQUEST) {
			if(msg.getCt() == Content.M_DEVICE && msg.getCtt() == ContentType.JSON) {
				msg.setTo(DeviceName.MASHUP);
				msg.setId(KWGateway.ID);
				process.send(new Post(To.MASHUP, msg.getJSONMessage()));
			}
		}
	}

	public void onReceivePacket(KETIClient arg0, byte[] arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public void onSendMsg(String arg0) {
		// TODO Auto-generated method stub

	}

	public void onSendPacket(byte[] arg0) {
		// TODO Auto-generated method stub

	}

	public void onSendFile(String name, long size) {
		// TODO Auto-generated method stub
		
	}

}
