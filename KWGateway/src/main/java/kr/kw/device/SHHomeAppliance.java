package kr.kw.device;

import kr.kw.database.DatabaseMapper;
import kr.kw.gateway.KWGateway;
import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.utas.function.UtasDeviceFunction;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceName;
import re.kr.keti.shprotocol.item.HomeAppliance;

public class SHHomeAppliance extends HomeAppliance implements DatabaseMapper {
	private int device;
	private int deviceNo;
	private int zone;

	// common function
	private int onOff;

	// special function
	private HAFunction function;

	public SHHomeAppliance(int device, int deviceNo, int zone, HAFunction function) {
		super();
		this.device = device;
		this.deviceNo = deviceNo;
		this.zone = zone;
		this.onOff = UtasDeviceFunction.UNKNOWN;
		this.function = function;
	}

	public SHHomeAppliance(int device, int deviceNo, int zone, int onOff, HAFunction function) {
		super();
		this.device = device;
		this.deviceNo = deviceNo;
		this.zone = zone;
		this.onOff = onOff;
		this.function = function;
	}

	public int getDevice() {
		return device;
	}

	public int getDeviceNo() {
		return deviceNo;
	}

	public int getZone() {
		return zone;
	}

	public int getOnOff() {
		return onOff;
	}

	public HAFunction getHAFunction() {
		return function;
	}
	
	public void setHAFunction(HAFunction function) {
		this.function = function;
	}

	// @Override
	// public String toString() {
	// return "UtasHomeAppliance [device=" + device + ", deviceNo=" + deviceNo +
	// ", zone=" + zone + ", onOff=" + onOff
	// + ", function=" + function.getFunctionList() +"]\n";
	// }

	@Override
	public String toString() {
		return "[" + UtasDeviceName.get(device) + "]" + "[" + deviceNo + "]" + " onOff=" + function.getFunctionList();
	}

	public void mapping() {
		super.haid = "utas-" + device + "-" + deviceNo;
		super.hanm = UtasDeviceName.get(device);
		super.hat = device;
		super.hafc = "zone=" + zone + "," + function.getFunctionList();
		super.hamf = function.getManuf();
		super.gwid = KWGateway.ID;
	}

}
