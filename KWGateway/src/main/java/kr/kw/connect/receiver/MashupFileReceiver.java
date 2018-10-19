package kr.kw.connect.receiver;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.gateway.KWGateway;
import kr.kw.protocol.MashupProtocol;
import kr.kw.util.KWLOG;
import kr.re.keti.socket.IKETIClientReceiver;
import kr.re.keti.socket.KETISockError;

public class MashupFileReceiver implements IKETIClientReceiver {
	private static final String TAG = "MashupFileReceiver";

	private GWProcess process;

	public MashupFileReceiver(GWProcess process) {
		this.process = process;
	}

	public void receiveString(String message) {
		KWLOG.debug(TAG, message);
	}

	public void receiveByte(byte[] packet, int length) {
		// TODO Auto-generated method stub
		
	}

	public void onConnected(String message) {
		KWLOG.debug(TAG, message);
		process.send(new Post(To.MASHUPFILE, MashupProtocol.register(KWGateway.ID + "-file")));
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
			process.reconnect(To.MASHUPFILE);
		}
	}

	public void uploadFile(String file) {
		process.addContextAwareness(file);
	}

}
