package kr.kw.connect.receiver;

import java.util.List;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.device.SHMirrorTV;
import kr.kw.protocol.MirrorTVProtocol;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.DBManager;
import kr.re.keti.socket.IKETIServerReceiver;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.shprotocol.KMessage;
import re.kr.keti.shprotocol.define.Commend;
import re.kr.keti.shprotocol.define.Content;
import re.kr.keti.shprotocol.define.ContentType;
import re.kr.keti.shprotocol.define.MessageType;
import re.kr.keti.shprotocol.item.IType;
import re.kr.keti.shprotocol.item.Schedule;
import re.kr.keti.shprotocol.item.Smartphone;

public class MirrorTVReceiver implements IKETIServerReceiver {
	private static final String TAG = "MirrorTVReceiver";
	
	private GWProcess process;
	public MirrorTVReceiver(GWProcess process) {
		this.process = process;
	}
	
	public void onAddClient(KETIClient client) {
		// TODO Auto-generated method stub
		KWLOG.info(TAG, "connected: " + client.getHostName());
	}

	public void onDisconnectClient(KETIClient client) {
		// TODO Auto-generated method stub
		KWLOG.info(TAG, "disconnected: " + client.getHostName());
		
		process.delete(IType.MIRRORTV, new SHMirrorTV(client));
	}

	public void onError(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onGetServerInfo(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onReceiveMsg(KETIClient client, String message) {
		KWLOG.debug(TAG, "message: " + message);
		KMessage m = KMessage.getMessage(message);
		if(m.getMt() == MessageType.REQUEST) {
			if(m.getCt() == Content.SCHEDULE && m.getCtt() == ContentType.JSON) {
				Schedule schedule = m.getSchedule();
				switch(m.getCmd()) {
				case Commend.CREATE:
					Schedule cscd = (Schedule) process.collect(IType.SCHD, schedule);
					process.send(new Post(To.MIRRORTV, client, 
							MirrorTVProtocol.resCreate(cscd)));
					break;
				case Commend.DELETE:
					Schedule dscd = (Schedule) process.delete(IType.SCHD, schedule);
					process.send(new Post(To.MIRRORTV, client, 
							MirrorTVProtocol.resDelete(dscd)));
					break;
				case Commend.RETREIVE:
					@SuppressWarnings("unchecked")
					List<Schedule> rscd = (List<Schedule>) process.retrieve(IType.SCHD, schedule);
					process.send(new Post(To.MIRRORTV, client, 
							MirrorTVProtocol.resRetrieve(rscd)));
					break;
				}
				
			} 
			
			else if(m.getCt() == Content.SMARTPHONE && m.getCtt() == ContentType.JSON) {
				Smartphone phone = m.getSmartphone();
				switch(m.getCmd()) {
				case Commend.RETREIVE:
					Smartphone latest = DBManager.getInstance().getSmartphoneDB().selectLatest(phone);
					process.send(new Post(To.MIRRORTV, client, 
							MirrorTVProtocol.resRetrieve(latest)));
					break;
				}
			}
			
			else if(m.getCt() == Content.MIRRORTV && m.getCtt() == ContentType.JSON) {
				SHMirrorTV mtv = new SHMirrorTV(client, m.getMirrorTV());
				switch(m.getCmd()) {
				case Commend.CREATE:
					process.collect(IType.MIRRORTV, mtv);
					break;
				}
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
