package kr.kw.connect.receiver;

import java.util.List;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.device.SHHomeAppliance;
import kr.kw.protocol.MonitoringProtocol;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.WorkingMemory;
import kr.re.keti.socket.IKETIServerReceiver;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.shprotocol.item.Service;

public class MonitoringReceiver implements IKETIServerReceiver {
	private static final String TAG = "MonitoringReceiver";
	
	private GWProcess process;
	
	public MonitoringReceiver(GWProcess process) {
		this.process = process;
	}
	
	public void onReceiveMsg(KETIClient client, String message) {
		KWLOG.debug(TAG, "message: " + message);
	}

	public void onReceivePacket(KETIClient client, byte[] packet, int length) {
		// TODO Auto-generated method stub
		
	}

	public void onSendMsg(String message) {
		// TODO Auto-generated method stub
		
	}

	public void onGetServerInfo(String info) {
		// TODO Auto-generated method stub
	}

	public void onAddClient(KETIClient client) {
		KWLOG.info(TAG, "connected: " + client.getHostName());
		
		List<SHHomeAppliance> haes = WorkingMemory.getInstance().getHAManager().getHomeAppliances();
		for(SHHomeAppliance ha : haes) {
			process.send(new Post(To.MONITORING, client, MonitoringProtocol.notiHA(ha)));	
		}
		
		List<Service> services = WorkingMemory.getInstance().getServiceManager().getServices();
		for(Service srv : services) {
			process.send(new Post(To.MONITORING, client, MonitoringProtocol.updateService(srv)));	
		}

		List<Service> mashup = WorkingMemory.getInstance().getMashupManager().getServices();
		process.send(new Post(To.MONITORING, client, MonitoringProtocol.updateMashup(mashup)));
		
	}

	public void onDisconnectClient(KETIClient client) {
		KWLOG.info(TAG, "disconnected: " + client.getHostName());
	}

	public void onError(String message) {
	}

	public void onSendPacket(byte[] packet) {
		// TODO Auto-generated method stub
		
	}

	public void onSendFile(String name, long size) {
		// TODO Auto-generated method stub
		
	}

}
