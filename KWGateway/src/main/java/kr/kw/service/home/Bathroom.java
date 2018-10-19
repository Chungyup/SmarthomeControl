package kr.kw.service.home;

import kr.kw.controller.GWProcess;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.lcy.device.utas.function.UtasLightFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasPacketTimer;
import re.kr.keti.lcy.device.utas.packet.collect.PacketSHCollection;

public class Bathroom extends HomeRelation {
	private static final int MODE_LIGHT_ON = 1;		
	private static final int MODE_LIGHT_OFF = 2;	
	
	private int prelocation;
	private int location1;
	private int location2;
	private int location3;
	
	public Bathroom(int prelocation, int location1, int location2, int location3) {
		this.prelocation = prelocation;
		this.location1 = location1;
		this.location2 = location2;
		this.location3 = location3;
	}
	
	@Override
	public double[] getInstances() {
		double[] instances = new double[7];
		instances[0] = getLocation(prelocation);
		instances[1] = getLocation(location1);
		instances[2] = getLocation(location2);
		instances[3] = getLocation(location3);
		instances[4] = getDatePosition();
		instances[5] = getTime();
		
		return instances;
	}

	@Override
	public void start(GWProcess process, HomeApplianceManager haMgr) {
		switch(predict) {
		case MODE_LIGHT_ON:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_2, UtasLightFunction.ON)) {
				process.controlDevice(PacketSHCollection.lighting2(UtasLightFunction.ON), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		case MODE_LIGHT_OFF:
			if(!haMgr.equalOnOff(UtasDeviceType.LIGHT, UtasDeviceNo.NO_2, UtasLightFunction.OFF)) {
				process.controlDevice(PacketSHCollection.lighting2(UtasLightFunction.OFF), UtasPacketTimer.INTERVAL_CTR);
			}
			break;
		}
	}

}
