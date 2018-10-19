package kr.kw.connect.receiver;

import kr.kw.controller.GWProcess;
import kr.kw.util.KWLOG;
import kr.kw.util.KWUtils;
import kr.re.keti.socket.IKETIServerReceiver;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class HAServerReceiver implements IKETIServerReceiver {
	private static final String TAG = "HAServerReceiver";
	
	private GWProcess process;
	
	public HAServerReceiver(GWProcess process) {
		this.process = process;
	}
	
	public void onReceiveMsg(KETIClient client, String message) {
		KWLOG.debug(TAG, message);
	}

	public void onReceivePacket(KETIClient client, byte[] packet, int length) {
		if(!UtasPacket.isValid(packet, length)) {
			KWLOG.debug(TAG, "invalid packet");	
			return;
		}
		
		KWLOG.debug(TAG, KWUtils.bytesToHexString(packet, length));
		
		process.analyzeUtasPacket(packet, length);
	}

	public void onSendMsg(String message) {
		// TODO Auto-generated method stub
	}

	public void onGetServerInfo(String info) {
		// TODO Auto-generated method stub
	}

	public void onAddClient(KETIClient client) {
		KWLOG.info(TAG, "connected: " + client.getHostName());
	}

	public void onDisconnectClient(KETIClient client) {
		KWLOG.info(TAG, "disconnected: " + client.getHostName());
	}

	public void onError(String message) {
		// TODO Auto-generated method stub
	}

	public void onSendPacket(byte[] packet) {
		// TODO Auto-generated method stub
		
	}

	public void onSendFile(String name, long size) {
		// TODO Auto-generated method stub
		
	}

}
