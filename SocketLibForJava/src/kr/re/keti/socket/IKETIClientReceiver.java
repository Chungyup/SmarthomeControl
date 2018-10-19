package kr.re.keti.socket;


public interface IKETIClientReceiver {
	void receiveString(String message);
	void receiveByte(byte[] packet, int length);
	void uploadFile(String file);
	void onConnected(String message);
	void onDisconnected(String messagae);
	void onError(int id, String message);
}
