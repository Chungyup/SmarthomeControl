package kr.re.keti.socket;

import kr.re.keti.socket.KETIServerSocket.KETIClient;
import kr.re.keti.socket.KETIServerSocket.READ_TYPE;

public class Test {
	private static final KETIServerSocket SERVER = new KETIServerSocket(READ_TYPE.BYTE);
	
	public static void main(String args[]) {
		SERVER.connect(8888);
		SERVER.registerIKETISocketListener(new IKETIServerReceiver() {

			@Override
			public void onReceiveMsg(KETIClient client, String message) {
				System.out.println(message + " from " + client.getHostName());
			}

			@Override
			public void onReceivePacket(KETIClient client, byte[] packet, int length) {
				System.out.println(new String(packet, 0, length) + " from " + client.getHostName());
			}

			@Override
			public void onSendMsg(String message) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSendPacket(byte[] packet) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onGetServerInfo(String info) {
				System.out.println(info);
			}

			@Override
			public void onAddClient(KETIClient client) {
				System.out.println("connect: " + client.getHostName());
			}

			@Override
			public void onDisconnectClient(KETIClient client) {
				System.out.println("disconnect: " + client.getHostName());
			}

			@Override
			public void onError(String message) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSendFile(String name, long size) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
