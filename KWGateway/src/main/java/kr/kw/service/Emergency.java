package kr.kw.service;

import kr.kw.connect.Post;
import kr.kw.connect.To;
import kr.kw.controller.GWProcess;
import kr.kw.protocol.BMSProtocol;
import kr.kw.protocol.MirrorTVProtocol;
import re.kr.keti.lcy.device.maxfor.item.MaxforScreemDectect;
import re.kr.keti.lcy.device.maxfor.item.MaxforSmartBand;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceGroup;
import re.kr.keti.shprotocol.item.Sensor;

public class Emergency {
	private GWProcess process;
	
	public Emergency(GWProcess process) {
		this.process = process;
	}
	
	public boolean run(Sensor sensor) {
		switch(sensor.getSst()) {
		case MaxforDeviceGroup.SMARTBAND:
			int fdet = Integer.parseInt(sensor.getStateOf("fdet"));
			if(fdet == MaxforSmartBand.FALL_DETECT) {
//				Post bPost = new Post(To.BMS, BMSProtocol.emerUpdate(sensor));
				Post mPost = new Post(To.MIRRORTV, MirrorTVProtocol.emerUpdate(sensor));
//				process.send(bPost);
				process.send(mPost);
				
			}
			return true;
		case MaxforDeviceGroup.SCREAM_DECTECTOR:
			int sdet = Integer.parseInt(sensor.getStateOf("value"));
			if(sdet == MaxforScreemDectect.SCREAM_DETECT) {
				Post bPost = new Post(To.BMS, BMSProtocol.emerUpdate(sensor));
				Post mPost = new Post(To.MIRRORTV, MirrorTVProtocol.emerUpdate(sensor));
				process.send(bPost);
				process.send(mPost);
			}
			return true;
		}
		
		
		return false;
	}
}
