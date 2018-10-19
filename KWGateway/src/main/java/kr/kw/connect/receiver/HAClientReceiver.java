package kr.kw.connect.receiver;

import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.util.KWLOG;
import kr.kw.util.KWUtils;
import kr.re.keti.socket.IKETIClientReceiver;
import kr.re.keti.socket.KETISockError;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

/**
 * class to receive data from home appliance
 * 
 * **/
public class HAClientReceiver implements IKETIClientReceiver {
	private static final String TAG = "HAClientReceiver";

	private GWProcess process;
	
	public HAClientReceiver(GWProcess process) {
		this.process = process;
	}
	
	public void receiveString(String message) {
		// not to do
	}

	public void receiveByte(byte[] packet, int length) {
		if(!UtasPacket.isValid(packet, length)) {
			KWLOG.debug(TAG, "invalid packet");	
			return;
		}
		
		KWLOG.debug(TAG, KWUtils.bytesToHexString(packet, length));
		
		process.analyzeUtasPacket(packet, length);
	}
	
	public void onConnected(String message) {
		KWLOG.info(TAG, "connected: " + message);
//		byte[] allStates = new UtasPacket().makeAllHAStatesWrite();
//		process.requestUtasController(allStates);
	}

	public void onDisconnected(String message) {
		KWLOG.info(TAG, "disconnected: " + message);
	}

	public void onError(int id, String message) {
		KWLOG.debug(TAG, "err: " + message);
		
		switch(id) {
		case KETISockError.ERR_CONNECT:
		case KETISockError.ERR_DISCONNECT:
		case KETISockError.ERR_INPUT:
		case KETISockError.ERR_OUTPUT:
			// try to reconnect
			process.reconnect(To.HA);
		}
	}

	public void uploadFile(String file) {
		// TODO Auto-generated method stub
		
	}
}
