package kr.kw.device;

import kr.kw.database.DatabaseMapper;
import kr.kw.gateway.KWGateway;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.device.maxfor.packet.MaxforDeviceName;
import re.kr.keti.shprotocol.item.Sensor;

public class SHSensor extends Sensor implements DatabaseMapper {
	private int sensorGroup;
	private int deviceId;
	private SensorState state;
	
	public SHSensor(int sensorGroup, int deviceId, SensorState state) {
		this.sensorGroup = sensorGroup;
		this.deviceId = deviceId;
		this.state = state;
	}
	
	public boolean same(int sensorGroup, int nodeId) {
		return this.sensorGroup == sensorGroup && this.deviceId == nodeId;
	}
	
	public int getSensorGroup() {
		return sensorGroup;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	
	public SensorState getSensorState() {
		return state;
	}
	
	public void setState(SensorState state) {
		this.state = state;
	}
	
	public SensorState getState() {
		return state;
	}
	
	public void mapping() {
		super.ssid = state.getManuf() + sensorGroup + "-" + deviceId;
		super.ssnm = MaxforDeviceName.get(sensorGroup);
		super.sst = sensorGroup;
		super.ssst = state.getStateList();
		super.ssmf = state.getManuf();
		super.gwid = KWGateway.ID;
	}
	
	@Override
	public String toString() {
		return "[" + MaxforDeviceName.get(sensorGroup) + "]" + "[" + deviceId + "]" + " " + state.toString();
	}
}
