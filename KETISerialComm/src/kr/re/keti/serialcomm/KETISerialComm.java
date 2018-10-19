package kr.re.keti.serialcomm;

import java.io.IOException;
import java.io.InputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class KETISerialComm {
	private static final String TAG = "KETISerialComm";
	
	private boolean isReading;
	private static InputStream in;
	private Thread reader;
	private String port;
	
	private KETISerialReceiver mSerialReceiver;
	
	public KETISerialComm() {
		isReading = false;
	}
	
	public void registerReceiver(KETISerialReceiver serialReceiver) {
		this.mSerialReceiver = serialReceiver;
	}
	
	private void read() {
		isReading = true;
		
		reader = new Thread(new Runnable() {

			public void run() {
				while(isReading) {
					byte[] buffer = new byte[1024];
					int len = -1;
					try {
						while ((len = KETISerialComm.in.read(buffer)) > -1) {
//							String data = new String(buffer, 0, len);
//							if(data != null) {
							KETILOG.debug(TAG, "read data = " + buffer);
							if(mSerialReceiver != null)
								mSerialReceiver.receive(port, buffer, len);	

//							buffer = new byte[1024];
//							}
						}
					} catch (IOException e) {
						KETILOG.exception(TAG, e.getMessage());
						e.printStackTrace();
					}
				}
			}
			
		});
		reader.start();
	}
	
	public void connect(String port, int baudrate) {
		KETILOG.debug(TAG, "port connecting");
		this.port = port;
		
		try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
			KETILOG.debug(TAG, "port connected");
			if (portIdentifier.isCurrentlyOwned()) {
				KETILOG.debug(TAG, "port is currently in use");
			} else {
				CommPort commPort = portIdentifier.open(this.getClass().getName(), 5000);
	
				if (commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort) commPort;
					serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					in = serialPort.getInputStream();
					read();
					KETILOG.debug(TAG, "start reading data");
				}
			}
		
		} catch (Exception e) {
			KETILOG.exception(TAG, e.getMessage());
		}
	}
	
	public void exit() {
		isReading = false;
	}
	
	public void listPorts() {
		@SuppressWarnings("unchecked")
		java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();

		KETILOG.debug(TAG, "port list");
		while ( portEnum.hasMoreElements() ) {
			CommPortIdentifier portIdentifier = portEnum.nextElement();
			KETILOG.debug(TAG, portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()));
		}
	}
	
	private String getPortTypeName(int portType) {
        switch ( portType ) {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "Parallel";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }
}
