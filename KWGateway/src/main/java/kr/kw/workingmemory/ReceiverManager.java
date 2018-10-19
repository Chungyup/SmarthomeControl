package kr.kw.workingmemory;

import kr.kw.connect.receiver.BMSReceiver;
import kr.kw.connect.receiver.HAClientReceiver;
import kr.kw.connect.receiver.HAServerReceiver;
import kr.kw.connect.receiver.MashupFileReceiver;
import kr.kw.connect.receiver.MashupReceiver;
import kr.kw.connect.receiver.MirrorTVReceiver;
import kr.kw.connect.receiver.MonitoringReceiver;
import kr.kw.connect.receiver.PhoneReceiver;
import kr.kw.connect.receiver.SensorReceiver;
import kr.kw.controller.GWProcess;

/**
 * class to manage message receivers
 * 
 * **/
public class ReceiverManager {
	private static ReceiverManager instance = null;
	
	public static ReceiverManager getInstance(GWProcess process) {
		if(instance == null) {
			instance = new ReceiverManager(process);
		}
		
		return instance;
	}
	
	private BMSReceiver bmsReceiver;
	private HAClientReceiver haClientReceiver;
	private HAServerReceiver haServerReceiver;
	private SensorReceiver maxforSensorReceiver;
	private MashupReceiver mashupReceiver;
	private MashupFileReceiver mashupFileReceiver;
	private MonitoringReceiver monitoringReceiver;
	private MirrorTVReceiver mirrorTVReceiver;
	private PhoneReceiver appReceiver;
	
	private ReceiverManager(GWProcess process) {
		bmsReceiver = new BMSReceiver(process);
		haClientReceiver = new HAClientReceiver(process);
		haServerReceiver = new HAServerReceiver(process);
		maxforSensorReceiver = new SensorReceiver(process);
		mashupReceiver = new MashupReceiver(process);
		mashupFileReceiver = new MashupFileReceiver(process);
		monitoringReceiver = new MonitoringReceiver(process);
		mirrorTVReceiver = new MirrorTVReceiver(process);
		appReceiver = new PhoneReceiver(process);
	}
	
	public BMSReceiver getBMSReceiver() {
		return bmsReceiver;
	}

	public SensorReceiver getMaxforSensorReceiver() {
		return maxforSensorReceiver;
	}

	public HAClientReceiver getHAClientReceiver() {
		return haClientReceiver;
	}
	
	public HAServerReceiver getHAServerReceiver() {
		return haServerReceiver;
	}
	
	public MashupReceiver getMashupReceiver() {
		return mashupReceiver;
	}
	
	public MashupFileReceiver getMashupFileReceiver() {
		return mashupFileReceiver;
	}
	
	public MonitoringReceiver getMonitoringReceiver() {
		return monitoringReceiver;
	}
	
	public MirrorTVReceiver getMirrorTVReceiver() {
		return mirrorTVReceiver;
	}
	
	public PhoneReceiver getAppReceiver() {
		return appReceiver;
	}
}
