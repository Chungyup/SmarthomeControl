package kr.kw.connect;

import kr.kw.util.KWLOG;
import kr.kw.workingmemory.ReceiverManager;
import kr.re.keti.serialcomm.KETISerialComm;
import kr.re.keti.socket.KETIClientSocket;
import kr.re.keti.socket.KETIServerSocket;
import kr.re.keti.socket.KETIServerSocket.KETIClient;

public class Connector {
	private static final String TAG = "Connector";

	public static boolean USE_BMS_CLIENT = false;
	public static boolean USE_HA_CLIENT = false;
	public static boolean USE_HA_SERVER = false;
	public static boolean USE_SENSOR_SERVER = false;
	public static boolean USE_SERIAL = false;
	public static boolean USE_MASHUP = false;
	public static boolean USE_MIRRORTV = false;
	public static boolean USE_APP = false;
	public static boolean USE_MONITORING = false;

	// home appliance
	private KETIClientSocket haClient;
	private KETIServerSocket haServer;

	// sensor
	private KETIServerSocket maxforIntegServer;
	private KETISerialComm maxforSerialComm;

	// BMS
	private KETIClientSocket bmsClient;

	// KETI
	private KETIClientSocket mashupClient;
	private KETIClientSocket mashupFileClient;
	private KETIServerSocket monitoringServer;
	private KETIServerSocket mirrortvServer;
	private KETIServerSocket appServer;
	
	private ReceiverManager receiverManager;

	public Connector(ReceiverManager receiverManager) {

		if (USE_HA_CLIENT)
			haClient = new KETIClientSocket(Address.HA_SERVER, Port.HA_CLIENT_PORT, KETIClientSocket.READ_TYPE.BYTE);

		if (USE_HA_SERVER)
			haServer = new KETIServerSocket(KETIServerSocket.READ_TYPE.BYTE);
		
		if (USE_SENSOR_SERVER)
			maxforIntegServer = new KETIServerSocket(KETIServerSocket.READ_TYPE.BYTE);

		if (USE_SERIAL) {
			maxforSerialComm = new KETISerialComm();
//			maxforSerialComm.listPorts();
		}
		
		if(USE_BMS_CLIENT)
			bmsClient = new KETIClientSocket(Address.BMS_SERVER, Port.BMS_PORT, KETIClientSocket.READ_TYPE.STRING);

		if (USE_MASHUP) {
			mashupClient = new KETIClientSocket(Address.MASHUP, Port.MASHUP, KETIClientSocket.READ_TYPE.STRING);
			mashupFileClient = new KETIClientSocket(Address.MASHUP, Port.MASHUP, KETIClientSocket.READ_TYPE.FILE, "arff/home/");
		}
		
		if (USE_MONITORING)
			monitoringServer = new KETIServerSocket(KETIServerSocket.READ_TYPE.STRING);

		if (USE_MIRRORTV)
			mirrortvServer = new KETIServerSocket(KETIServerSocket.READ_TYPE.STRING);
		
		if (USE_APP)
			appServer = new KETIServerSocket(KETIServerSocket.READ_TYPE.STRING);
		
		this.receiverManager = receiverManager;
		registerReceivers();
	}

	public void connectAllServer() {
		if (USE_HA_SERVER)
			haServer.connect(Port.HA_SERVER_PORT);
		
		if (USE_SENSOR_SERVER)
			maxforIntegServer.connect(Port.SENSOR_PORT);

		if (USE_MONITORING)
			monitoringServer.connect(Port.MONITORING);
		
		if (USE_MIRRORTV) 
			mirrortvServer.connect(Port.MIRROTTV);
		
		if (USE_APP)
			appServer.connect(Port.APP);
		
	}

	public void connectAllClient() {
		if (USE_HA_CLIENT)
			haClient.connect();
		
		if (USE_MASHUP) {
			mashupClient.connect();
			mashupFileClient.connect();
		}
		
		if (USE_BMS_CLIENT)
			bmsClient.connect();
	}

	public void connectAllSerial() {
		if (USE_SERIAL) {
			try {
				maxforSerialComm.connect(Serial.PORT, Serial.BAUDRATE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void reconnect(To type) throws InterruptedException {
		switch(type) {
		case BMS:
			if (USE_BMS_CLIENT) {
				bmsClient.disconnect();
				Thread.sleep(10000);
				bmsClient.connect();
			}
			break;
		case HA:
			if (USE_HA_CLIENT) {
				haClient.disconnect();
				Thread.sleep(10000);
				haClient.connect();
			}
			break;
		case MASHUP:
			if (USE_MASHUP) {
				mashupClient.disconnect();
				Thread.sleep(10000);
				mashupClient.connect();
			}
			break;
		case MASHUPFILE:
			if (USE_MASHUP) {
				mashupFileClient.disconnect();
				Thread.sleep(10000);
				mashupFileClient.connect();
			}
			break;
		default:
			break;
		
		}
	}

	public void sendToUtasController(byte[] packet) {
		if (USE_HA_CLIENT && haClient.isConnected()) {
			haClient.sendBytes(packet);
		} else {
			KWLOG.debug(TAG, "not connected to the utas");
		}
	}
	
	public void sendToBMS(String message) {
		if (USE_BMS_CLIENT && bmsClient.isConnected()) {
			bmsClient.sendString(message);
		} else {
			KWLOG.debug(TAG, "not connected to the BMS");
		}
	}
	
	public void sendToMashup(String message) {
		if (USE_MASHUP && mashupClient.isConnected()) {
			mashupClient.sendString(message);
		} else {
			KWLOG.debug(TAG, "not connected to the mashup");
		}
	}
	
	public void sendToMashupFile(String message) {
		if (USE_MASHUP && mashupFileClient.isConnected()) {
			mashupFileClient.sendString(message);
		} else {
			KWLOG.debug(TAG, "not connected to the mashupfile");
		}
	}
	
	public void broadcastToMonitoring(String message) {
		if (USE_MONITORING) {
			monitoringServer.broadcast(message);
		} else {
			KWLOG.debug(TAG, "not connected to the monitoring");
		}
	}
	
	public void broadcastMirrorTV(String message) {
		if (USE_MIRRORTV) {
			mirrortvServer.broadcast(message);
		} else {
			KWLOG.debug(TAG, "not connected to the mirror tv");
		}
	}
	
	public void sendToMonitoring(KETIClient client, String message) {
		if (USE_MONITORING) {
			monitoringServer.sendTo(client, message);
		} else {
			KWLOG.debug(TAG, "not connected to the monitoring");
		}
	}
	
	public void sendToMirrorTV(KETIClient client, String message) {
		if (USE_MIRRORTV) {
			mirrortvServer.sendTo(client, message);
		} else {
			KWLOG.debug(TAG, "not connected to the mirror tv");
		}
	}
	
	
	public void sendToAPP(KETIClient client, String mesage) {
		if (USE_APP) {
			appServer.sendTo(client, mesage);
		} else {
			KWLOG.debug(TAG, "not connected to ths APP");
		}
	}

	public void finish() {
		if (USE_HA_CLIENT)
			haClient.disconnect();

		if (USE_HA_SERVER) {
			haServer.disconnectAllClient();
			haServer.close();
		}
		
		if (USE_BMS_CLIENT)
			bmsClient.disconnect();
			
		if (USE_MASHUP) {
			mashupClient.disconnect();
			mashupFileClient.disconnect();
		}
		
		if (USE_SENSOR_SERVER) {
			maxforIntegServer.disconnectAllClient();
			maxforIntegServer.close();
		}
		
		if (USE_MIRRORTV) {
			mirrortvServer.disconnectAllClient();
			mirrortvServer.close();
		}
		
		if (USE_APP) {
			appServer.disconnectAllClient();
			appServer.close();
		}	
	}

	public void closeAll() {
		if (USE_HA_SERVER)
			haServer.close();
		
		if (USE_SENSOR_SERVER)
			maxforIntegServer.close();

		if (USE_MONITORING)
			monitoringServer.close();
		
		if (USE_MIRRORTV)
			mirrortvServer.close();
		
		if (USE_APP)
			appServer.close();
	}

	private void registerReceivers() {
		if (USE_HA_CLIENT)
			haClient.registerReceiveListner(receiverManager.getHAClientReceiver());

		if (USE_HA_SERVER)
			haServer.registerIKETISocketListener(receiverManager.getHAServerReceiver());
		
		if (USE_SENSOR_SERVER)
			maxforIntegServer.registerIKETISocketListener(receiverManager.getMaxforSensorReceiver());

		if (USE_SERIAL)
			maxforSerialComm.registerReceiver(receiverManager.getMaxforSensorReceiver());

		if (USE_BMS_CLIENT)
			bmsClient.registerReceiveListner(receiverManager.getBMSReceiver());
		
		if (USE_MASHUP) {
			mashupClient.registerReceiveListner(receiverManager.getMashupReceiver());
			mashupFileClient.registerReceiveListner(receiverManager.getMashupFileReceiver());
		}
		
		if (USE_MONITORING)
			monitoringServer.registerIKETISocketListener(receiverManager.getMonitoringReceiver());
	
		if (USE_MIRRORTV)
			mirrortvServer.registerIKETISocketListener(receiverManager.getMirrorTVReceiver());
		
		if (USE_APP)
			appServer.registerIKETISocketListener(receiverManager.getAppReceiver());
	
	}
}
