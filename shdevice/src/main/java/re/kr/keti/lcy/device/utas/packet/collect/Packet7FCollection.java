package re.kr.keti.lcy.device.utas.packet.collect;

import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceZone;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class Packet7FCollection {
	public static UtasPacket lighting16(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_16,
				UtasDeviceZone.CLASSROOM_702, function);
	}
	
	public static UtasPacket lighting17(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_17,
				UtasDeviceZone.CLASSROOM_703, function);
	}
	
	public static UtasPacket lighting18(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_18,
				UtasDeviceZone.LABORATORY_704, function);
	}
	
	public static UtasPacket lighting19(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_19,
				UtasDeviceZone.CORRIOR_7, function);
	}
	
	public static UtasPacket acandheater7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_7,
				UtasDeviceZone.CLASSROOM_702, function);
	}
	
	public static UtasPacket acandheater8(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_8,
				UtasDeviceZone.LABORATORY_704, function);
	}
	
	public static UtasPacket ac2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AIRCONDITION, UtasDeviceNo.NO_2,
				UtasDeviceZone.CLASSROOM_703, function);
	}
	
	public static UtasPacket pc7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_7,
				UtasDeviceZone.LABORATORY_704, function);
	}
	
	public static UtasPacket doorlock7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_7,
				UtasDeviceZone.CLASSROOM_702, function);
	}
	
	public static UtasPacket doorlock8(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_8,
				UtasDeviceZone.CLASSROOM_703, function);
	}
	
	public static UtasPacket doorlock9(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_9,
				UtasDeviceZone.LABORATORY_704, function);
	}
}
