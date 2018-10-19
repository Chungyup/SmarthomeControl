package kr.re.keti.socket;


import kr.re.keti.socket.KETIServerSocket.KETIClient;

public interface IKETIServerReceiver {

	/**
	 * 클라이언트가 보낸 메시지를 받음.
	 * 
	 * @param hostIp 메시지 보낸 클라이언트 IP
	 * @param message 클라이언트가 보낸 메시지
	 * */
	void onReceiveMsg(KETIClient client, String message);
	
	/**
	 * 클라이언트가 보낸 패킷을 받음.
	 * 
	 * @param hostIp 메시지 보낸 클라이언트 IP
	 * @param message 클라이언트가 보낸 메시지
	 * */
	void onReceivePacket(KETIClient client, byte[] packet, int length);
	
	/**
	 * 서버가 보낸 메시지를 받음.
	 * 
	 * @param message 서비가 보낸 메시지
	 * */
	void onSendMsg(String message);
	
	/**
	 * 서버가 보낸 파일을 받음.
	 * 
	 * @param message 서비가 보낸 메시지
	 * */
	void onSendFile(String name, long size);
	
	/**
	 * 서버가 보낸 패킷을 받음.
	 * 
	 * @param packet 서비가 보낸 패킷
	 * */
	void onSendPacket(byte[] packet);
	
	/**
	 * 현재 서버의 정보를 받음.
	 * 
	 * @param info 서버 정보
	 * */
	void onGetServerInfo(String info);
	
	/**
	 * 접속한 클라이언트의 정보를 받음.
	 * 
	 * @param client 클라이언트 정보
	 * */
	void onAddClient(KETIClient client);
	
	/**
	 * 접속을 종료한 클라이언트의 정보를 받음.
	 * 
	 * @param client 클라이언트 정보
	 * */
	void onDisconnectClient(KETIClient client);
	
	/**
	 * 접속한 클라이언트의 오류 정보를 받음.
	 * 
	 * @param message 오류 정보
	 * */
	void onError(String message);
}
