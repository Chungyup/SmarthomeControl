package re.kr.keti.lcy.device.utas.packet.collect;

import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceZone;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class Packet1FCollection {
	
	public static UtasPacket lighting6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_6,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket lighting7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_7,
				UtasDeviceZone.COMPUTER_ROOM_104_ENTRANCE, function);
	}
	
	public static UtasPacket lighting8(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_8,
				UtasDeviceZone.CORRIDOR_1_1, function);
	}
	
	public static UtasPacket lighting9(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_9,
				UtasDeviceZone.CORRIDOR_1_2, function);
	}
	
	public static UtasPacket acandheater2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_2,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket pc1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_1,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket pc2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_2,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket pc3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_3,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket pc4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_4,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket doorlock2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.PC, UtasDeviceNo.NO_2,
				UtasDeviceZone.COMPUTER_ROOM_104_ENTRANCE, function);
	}
	
	public static UtasPacket tv5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_5,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_6,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_7,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv8(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_8,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv9(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_9,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv10(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_10,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv11(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_11,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
	
	public static UtasPacket tv12(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_12,
				UtasDeviceZone.COMPUTER_ROOM_103, function);
	}
}
