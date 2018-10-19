package kr.kw.connect.receiver;

import kr.kw.controller.GWProcess;
import kr.kw.util.KWLOG;
import kr.re.keti.serialcomm.KETISerialReceiver;
import kr.re.keti.socket.IKETIServerReceiver;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.lcy.device.maxfor.packet.MaxforPacket;

/**
 * class to receive data from sensors
 * 
 * **/
public class SensorReceiver implements IKETIServerReceiver, KETISerialReceiver {
	private static final String TAG = "SensorReceiver";
	
	private GWProcess process;
	
	public SensorReceiver(GWProcess process) {
		this.process = process;
	}
	
	public void onReceiveMsg(KETIClient client, String message) {
		KWLOG.debug(TAG, message);
	}

	public void onReceivePacket(KETIClient client, byte[] packet, int length) {
		if(!MaxforPacket.isValid(packet, length)) {
			KWLOG.debug(TAG, "invalid packet");	
			return;
		}
		KWLOG.debug(TAG, "receive a packet from " + client.getHostName());
//		KWLOG.debug(TAG, Utils.bytesToHexString(packet, length));
		
		process.analyzeMaxforPacket("socket-"+client.getHostName(), packet, length);
	}

	public void receive(String port, byte[] packet, int length) {
		process.analyzeMaxforPacket("serial-"+port, packet, length);
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
