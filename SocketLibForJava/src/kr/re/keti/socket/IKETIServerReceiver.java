package kr.re.keti.socket;


import kr.re.keti.socket.KETIServerSocket.KETIClient;

public interface IKETIServerReceiver {

	/**
	 * Ŭ���̾�Ʈ�� ���� �޽����� ����.
	 * 
	 * @param hostIp �޽��� ���� Ŭ���̾�Ʈ IP
	 * @param message Ŭ���̾�Ʈ�� ���� �޽���
	 * */
	void onReceiveMsg(KETIClient client, String message);
	
	/**
	 * Ŭ���̾�Ʈ�� ���� ��Ŷ�� ����.
	 * 
	 * @param hostIp �޽��� ���� Ŭ���̾�Ʈ IP
	 * @param message Ŭ���̾�Ʈ�� ���� �޽���
	 * */
	void onReceivePacket(KETIClient client, byte[] packet, int length);
	
	/**
	 * ������ ���� �޽����� ����.
	 * 
	 * @param message ���� ���� �޽���
	 * */
	void onSendMsg(String message);
	
	/**
	 * ������ ���� ������ ����.
	 * 
	 * @param message ���� ���� �޽���
	 * */
	void onSendFile(String name, long size);
	
	/**
	 * ������ ���� ��Ŷ�� ����.
	 * 
	 * @param packet ���� ���� ��Ŷ
	 * */
	void onSendPacket(byte[] packet);
	
	/**
	 * ���� ������ ������ ����.
	 * 
	 * @param info ���� ����
	 * */
	void onGetServerInfo(String info);
	
	/**
	 * ������ Ŭ���̾�Ʈ�� ������ ����.
	 * 
	 * @param client Ŭ���̾�Ʈ ����
	 * */
	void onAddClient(KETIClient client);
	
	/**
	 * ������ ������ Ŭ���̾�Ʈ�� ������ ����.
	 * 
	 * @param client Ŭ���̾�Ʈ ����
	 * */
	void onDisconnectClient(KETIClient client);
	
	/**
	 * ������ Ŭ���̾�Ʈ�� ���� ������ ����.
	 * 
	 * @param message ���� ����
	 * */
	void onError(String message);
}
