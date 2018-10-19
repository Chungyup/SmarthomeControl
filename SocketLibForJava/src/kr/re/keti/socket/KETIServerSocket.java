package kr.re.keti.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class KETIServerSocket {
	private static final String TAG = "KETIServerSocket";
	
	public enum READ_TYPE {
		STRING,
		BYTE,
		FILE
	}
	
//	private static final int BACKLOG = 150;

	private IKETIServerReceiver mIKETISocketListener;

	public void registerIKETISocketListener(IKETIServerReceiver mIKETISocketListener) {
		this.mIKETISocketListener = mIKETISocketListener;
	}

	private ServerSocket serverSocket;

	private List<KETIClient> clients;

	private int port;

	private READ_TYPE readType;
	
	public KETIServerSocket(READ_TYPE readType) {
		clients = new ArrayList<KETIClient>();
		
		this.readType = readType;
		
		KETISocketLog.D = false;
	}

	public void connect(final int port) {
		if(serverSocket != null) {
			KETISocketLog.error(TAG, "Server was already started.");
			return;
		}
		
		this.port = port;

		new Thread(new Runnable() {
			public void run() {
				try {
//					serverSocket = new ServerSocket(port, BACKLOG);
					serverSocket = new ServerSocket(port);
					
					InetAddress mInetAddress = InetAddress.getLocalHost();
					mIKETISocketListener.onGetServerInfo(
							"host address: " + mInetAddress.getHostAddress() + ", " +
							"host name: " + mInetAddress.getHostName());

					KETISocketLog.info(TAG, "start server");

					while (true) {
						Socket socket = serverSocket.accept();
						
						KETISocketLog.info(TAG, "accepted");

//						if (clients.size() < BACKLOG) {
							KETIClient client = new KETIClient(socket);
							client.start();
							clients.add(client);
							KETISocketLog.info(TAG, "the number of current client: " + clients.size());

							mIKETISocketListener.onAddClient(client);
//						} else {
//							Log.error(TAG, "out of backlog: " + clients.size());
//						}
					}
				} catch (IOException e) {
					KETISocketLog.error(TAG, e.getMessage());
					mIKETISocketListener.onError(e.getMessage());
				}
			}
		}).start();
	}
	
	public void close() {
		try {
			serverSocket.close();
			serverSocket = null;
			KETISocketLog.info(TAG, "closed server");
		} catch (IOException e) {
			KETISocketLog.error(TAG, e.getMessage());
			mIKETISocketListener.onError(e.getMessage());
		}
	}

	public void disconnectAllClient() {
		synchronized (clients) {
			for(int i=0; i<clients.size(); i++) {
				KETIClient c = clients.get(i);
				c.disconnect();
			}

			clients.clear();			
		}
	}

	public class KETIClient extends Thread {
		String hostName;
		boolean isConnect;
		Socket socket;
		DataInputStream input;
		DataOutputStream output;

		public String getHostName() {
			return hostName;
		}

		public KETIClient(Socket socket) {
			this.socket = socket;
			hostName = socket.getInetAddress().getHostAddress();

			try {
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				isConnect = true;
			} catch (IOException e) {
				KETISocketLog.error(TAG, e.getMessage());
				isConnect = false;
			}
		}

		@Override
		public void run(){
			while (isConnect && input != null && socket != null && socket.isConnected()) {
				switch(readType) {
				case STRING:
					readString();
					break;
				case BYTE:
					readByte();
					break;
				case FILE:
					readFile();
					break;
				}
			}

			disconnect();
		}

		private void readString() {
			try {
				String rMsg = input.readUTF();
				mIKETISocketListener.onReceiveMsg(this, rMsg);
			} catch (IOException e) {
				KETISocketLog.error(TAG, "server receive error : " + e.getMessage());
				
				disconnect();
				isConnect = false;
			}
		}
		
		private void readByte() {
			try {
				byte[] buf = new byte[1024];
				int readLen = input.read(buf);
				
				if(readLen > 0) {
					mIKETISocketListener.onReceivePacket(this, buf, readLen);	
			
					KETISocketLog.info(TAG, "receive from " + hostName + ": " + KETISockUtil.byteArrayToHex(buf, readLen));
				}
			
			} catch (IOException e) {
				KETISocketLog.error(TAG, e.getMessage());
				disconnect();
				isConnect = false;
			}
		}
		private void readFile() {
			
		}
		
		private void send(String message) {
			try {
				if (socket.isConnected()) {
					output.writeUTF(message);
					output.flush();

					KETISocketLog.info(TAG, "send: " + message);
				} else {
					disconnect();
					isConnect = false;
				}
				
			} catch (IOException e) {
				KETISocketLog.error(TAG, "server send error: " + e.getMessage());
				
				disconnect();
				isConnect = false;
			}
		}
		
		private void send(byte[] packet) {
			try {
				if (socket.isConnected()) {
					output.write(packet);
					output.flush();
					
					KETISocketLog.info(TAG, "send: " + KETISockUtil.byteArrayToHex(packet, packet.length));
				} else {
					disconnect();
					isConnect = false;
				}
				
			} catch (IOException e) {
				KETISocketLog.error(TAG, "server send error: " + e.getMessage());
				disconnect();
				isConnect = false;
			}
		}
		
		private void send(File file) {
	        try {
	        	String fileName = file.getName();
	    		long fileSize = file.length();
	            long totalReadBytes = 0;
	            byte[] buffer = new byte[1024];
	            int readBytes = 0;
	        	FileInputStream fis = new FileInputStream(file);
	        	
//	        	System.out.println("file: " + fileName);
//	        	System.out.println("length" + fileSize);
	        	
	        	output.writeUTF(fileName);
	        	output.flush();
	        	output.writeUTF(String.valueOf(fileSize));
	        	output.flush();
				while ((readBytes = fis.read(buffer)) > 0) {
					output.write(buffer, 0, readBytes);
					output.flush();
	                totalReadBytes += readBytes;
//	                System.out.println(totalReadBytes + "/"
//	                        + fileSize + " Byte(s) ("
//	                        + (totalReadBytes * 100 / fileSize) + " %)");
	            }
				
				mIKETISocketListener.onSendFile(fileName, totalReadBytes);
//				KETISocketLog.info(TAG, "transfer the file of " + file.getName() + " [size: " + totalReadBytes + "bytes]");
	        } catch (FileNotFoundException e) {
	        	KETISocketLog.error(TAG, "server send error: " + e.getMessage());
	        	disconnect();
				isConnect = false;
	        } catch (IOException e) {
				KETISocketLog.error(TAG, "server send error: " + e.getMessage());		
				disconnect();
				isConnect = false;
			}
		}

		private void disconnect() {
			if (socket != null) {
				try {
					input.close();
					input = null;

					output.close();
					output = null;

					socket.close();
					socket = null;
					KETISocketLog.info(TAG, "disconnected");
					
					clients.remove(KETIClient.this);
					mIKETISocketListener.onDisconnectClient(KETIClient.this);
					KETISocketLog.info(TAG, "the number of current client: " + clients.size());
				} catch (IOException e) {
					KETISocketLog.error(TAG, "disconnect error: " + e.getMessage());
				}
			}
		}
	}
	
	public int getPort() {
		return port;
	}

	public void broadcast(String msg) {
		synchronized (clients) {	
			for(int i=0; i<clients.size(); i++) {
				KETIClient c = clients.get(i);
				c.send(msg);
			}
			
			KETISocketLog.info(TAG, "broadcast " + msg);
		
			mIKETISocketListener.onSendMsg(msg);
			
		}
	}
	
	public void broadcast(byte[] packet) {
		synchronized (clients) {	
			for(int i=0; i<clients.size(); i++) {
				KETIClient c = clients.get(i);
				c.send(packet);
			}
		}
	}

	public void sendTo(KETIClient client, String msg) {
		client.send(msg);
		
		mIKETISocketListener.onSendMsg(msg);
	}
	
	public void sendTo(KETIClient client, byte[] packet) {
		client.send(packet);
		
		mIKETISocketListener.onSendPacket(packet);
	}
	
	public void sendTo(KETIClient client, File file) {
		if (!file.exists()) {
			KETISocketLog.error(TAG, "File not exist.");
            return;
        }
	
		client.send(file);
	}
}
