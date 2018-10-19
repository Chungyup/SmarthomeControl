package re.kr.keti.lcy.device.utas.packet.collect;

import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceZone;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class Packet5FCollection {

	public static UtasPacket lighting10(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_10,
				UtasDeviceZone.SHCHOLARSHIP_OFFICE_502, function);
	}
	
	public static UtasPacket lighting11(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_11,
				UtasDeviceZone.LOUNGE_501, function);
	}
	
	public static UtasPacket lighting12(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_12,
				UtasDeviceZone.CORRIOR_5, function);
	}
	
	public static UtasPacket acandheater3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_3,
				UtasDeviceZone.SHCHOLARSHIP_OFFICE_502, function);
	}
	
	public static UtasPacket acandheater4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_4,
				UtasDeviceZone.LOUNGE_501, function);
	}
	
	public static UtasPacket pc5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_5,
				UtasDeviceZone.LOUNGE_501, function);
	}
	
	public static UtasPacket pc6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_6,
				UtasDeviceZone.LOUNGE_501, function);
	}
	
	public static UtasPacket doorlock3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_3,
				UtasDeviceZone.SHCHOLARSHIP_OFFICE_502, function);
	}
	
	public static UtasPacket doorlock4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_4,
				UtasDeviceZone.LOUNGE_501, function);
	}
}
