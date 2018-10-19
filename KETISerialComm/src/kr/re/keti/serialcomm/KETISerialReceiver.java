package kr.re.keti.serialcomm;

public interface KETISerialReceiver {
	public void receive(String port, byte[] data, int length);
}
