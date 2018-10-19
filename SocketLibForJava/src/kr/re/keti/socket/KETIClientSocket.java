package kr.re.keti.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class KETIClientSocket {
	private static final String TAG = "KETIClientSocket";
	
	public enum READ_TYPE {
		STRING,
		BYTE,
		FILE
	}
	
	private READ_TYPE readType;
	
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	private List<String> messages;
	private List<byte[]> packets;
	
	private String ip;
	private int port;
	
	private Receiver receiver;
	private IKETIClientReceiver mIReceiveListner;

	private String fileDir;
	public void registerReceiveListner(IKETIClientReceiver receiveListner) {
		this.mIReceiveListner = receiveListner;
	}

	public KETIClientSocket(String ip, int port) {
		this.messages = new ArrayList<String>();
		this.packets = new ArrayList<byte[]>();
		
		this.ip = ip;
		this.port = port;
		readType = READ_TYPE.STRING;
		
		KETISocketLog.D = false;
	}
	
	public KETIClientSocket(String ip, int port, READ_TYPE readType) {
		this(ip, port);
		this.readType = readType;
	}
	
	public KETIClientSocket(String ip, int port, READ_TYPE readType, String fileDir) {
		this(ip, port, readType);
		this.fileDir = fileDir;
	}

	public void connect() {
		new Thread(new Runnable() {
			public void run() {
				try {
					KETISocketLog.info(TAG, "connecting");
	
					socket = new Socket(ip, port);
	
					KETISocketLog.info(TAG, "connected");
	
					output = new DataOutputStream(socket.getOutputStream());
	
					input = new DataInputStream(socket.getInputStream());
	
					mIReceiveListner.onConnected("connected");
						
					receiver = new Receiver();
					new Thread(receiver).start();
				} catch (IOException e) {
					mIReceiveListner.onError(KETISockError.ERR_CONNECT, e.getMessage());
				}
			}
		}).start();
	}

	public void disconnect() {
		if (socket != null && !socket.isClosed()) {
			try {
				KETISocketLog.info(TAG, "disconnecting");
				
				input.close();
				input = null;
				
				output.close();
				output = null;
				
				socket.close();
				socket = null;
			
				receiver.stop();	
				
				mIReceiveListner.onDisconnected("disconnected");
				
				KETISocketLog.info(TAG, "disconnected");
			} catch (IOException e) {
				mIReceiveListner.onError(KETISockError.ERR_DISCONNECT, e.getMessage());
			}
		}
	}

	public boolean isConnected() {
		if(socket == null) {
			return false;
		}
		
		return socket.isConnected();
	}

	public void sendString(String message) {
		if (socket != null && socket.isConnected()) {
			messages.add(message);
			new StringSender().run();
		}
	}
	
	public void sendBytes(byte[] packet) {
		if (socket != null && socket.isConnected()) {
			packets.add(packet);
			new ByteSender().run();
		}
	}

	/**
	 * class to send messages, which are String
	 * 
	 * */
	class StringSender {
		private Thread sendThread;
		public StringSender() {
			sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						synchronized(messages) {
							for(int i=0; i<messages.size(); i++) {
								String message = messages.get(i);
								if(output != null && message != null) {
									output.writeUTF(message);
									output.flush();	
								}
								
								KETISocketLog.info(TAG, "send message: " + message);
							}
							
							messages.clear();	
						}
					} catch (IOException e) {
						messages.clear();
						mIReceiveListner.onError(KETISockError.ERR_OUTPUT, e.getMessage());
					}
				}
				
			});
		}
		
		public void run() {
			sendThread.start();
		}
	}
	
	
	/**
	 * class to send packets, which are byte
	 * 
	 * */
	class ByteSender {
		private Thread sendThread;
		public ByteSender() {
			sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						synchronized(packets) {
							for(int i=0; i<packets.size(); i++) {
								byte[] packet = packets.get(i);
								if(output != null && packet != null) {
									output.write(packet);
									output.flush();		
								
									KETISocketLog.info(TAG, "send message: " + KETISockUtil.byteArrayToHex(packet, packet.length));
								}
							}
							
							packets.clear();	
						}
					} catch (IOException e) {
						packets.clear();
						mIReceiveListner.onError(KETISockError.ERR_OUTPUT, e.getMessage());
					}
				}
			});
		}
		
		public void run() {
			sendThread.start();
		}
	}

	class Receiver implements Runnable {
		boolean onStart;
		
		public Receiver() {
			onStart = true;
		}
		
		public void stop() {
			onStart = false;
		}
		
		@Override
		public void run() {

			while (onStart && input != null && socket != null) {
				switch(readType) {
				case STRING:
					readString();
					break;
				case BYTE:
					readBytes();
					break;
				case FILE:
					readFile();
				}
			}
			
			disconnect();
		}
		
		public void readString() {
			try {
				String rMsg = input.readUTF();
				
				KETISocketLog.info(TAG, "receive message: " + rMsg);

				mIReceiveListner.receiveString(rMsg);
			} catch (IOException e) {
				mIReceiveListner.onError(KETISockError.ERR_INPUT, e.getMessage());
			}
		}
		
		private void readBytes() {
			try {
				byte[] buf = new byte[1024];
				int readLen = input.read(buf);
				
				if(readLen > 0) {
					mIReceiveListner.receiveByte(buf, readLen);
					
					KETISocketLog.info(TAG, "receive from " + KETISockUtil.byteArrayToHex(buf, readLen));	
				}
			} catch (IOException e) {
				KETISocketLog.error(TAG, e.getMessage());
				mIReceiveListner.onError(KETISockError.ERR_INPUT, e.getMessage());
			}
		}
		
		private void readFile() {
            try {
    			byte[] buffer = new byte[1024];
                int readBytes;
                
                String fileName = input.readUTF();
                long size = Long.parseLong(input.readUTF());
                int totalReadBytes = 0;
                FileOutputStream fos = new FileOutputStream(fileDir + fileName);
				while ((readBytes = input.read(buffer)) > 0) {
					fos.write(buffer, 0, readBytes);
					totalReadBytes += readBytes;
//					System.out.println(readBytes + "/" +size + "bytes");
					if(totalReadBytes == size) {
						break;
					}
				}
				fos.flush();
				fos.close();
				
				mIReceiveListner.uploadFile(fileName);
			} catch (IOException e) {
				KETISocketLog.error(TAG, e.getMessage());
				mIReceiveListner.onError(KETISockError.ERR_INPUT, e.getMessage());
			} 
		}
	}
}
