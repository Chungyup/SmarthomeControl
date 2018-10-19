package re.kr.keti.lcy.device.utas.packet.collect;

import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceZone;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class Packet6FCollection {
	public static UtasPacket lighting13(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_13,
				UtasDeviceZone.OFFICE_603, function);
	}
	
	public static UtasPacket lighting14(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_14,
				UtasDeviceZone.OFFICE_603_1, function);
	}
	
	public static UtasPacket lighting15(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_15,
				UtasDeviceZone.CORRIOR_6, function);
	}
	
	public static UtasPacket acandheater5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_5,
				UtasDeviceZone.OFFICE_603, function);
	}
	
	public static UtasPacket acandheater6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_6,
				UtasDeviceZone.OFFICE_603_1, function);
	}
	
	public static UtasPacket doorlock5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_5,
				UtasDeviceZone.OFFICE_603, function);
	}
	
	public static UtasPacket doorlock6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_6,
				UtasDeviceZone.OFFICE_603_1, function);
	}

}
