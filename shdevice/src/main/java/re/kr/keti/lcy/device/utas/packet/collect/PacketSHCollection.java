package re.kr.keti.lcy.device.utas.packet.collect;

import re.kr.keti.lcy.device.utas.packet.UtasDeviceNo;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceType;
import re.kr.keti.lcy.device.utas.packet.UtasDeviceZone;
import re.kr.keti.lcy.device.utas.packet.UtasModbusFC;
import re.kr.keti.lcy.device.utas.packet.UtasPacket;

public class PacketSHCollection {
	public static UtasPacket tv1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket tv2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_2,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket tv3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_3,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket tv4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.TV, UtasDeviceNo.NO_4,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket ac1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AIRCONDITION, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket acandheater1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AC_AND_HEATER, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket blind1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket blind2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_2,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket blind7(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_7,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket blind8(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_8,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket blind3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_3,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket blind4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_4,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket blind5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_5,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket blind6(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.BLIND, UtasDeviceNo.NO_6,
				UtasDeviceZone.BEDROOM_2, function);
	}
	
	public static UtasPacket heater1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.HEATER, UtasDeviceNo.NO_1,
				UtasDeviceZone.BEDROOM_2, function);
	}

	
	public static UtasPacket dvd1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DVD, UtasDeviceNo.NO_1,
				UtasDeviceZone.BEDROOM_1, function);
	}

	public static UtasPacket aircleaner1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AIRCLEANER, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket robotvacuum1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.ROBOTVACUUM, UtasDeviceNo.NO_1,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket audio1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.AUDIO, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}

	public static UtasPacket humidifier1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.HUMIDIFIER, UtasDeviceNo.NO_1,
				UtasDeviceZone.BEDROOM_2, function);
	}
	
	public static UtasPacket doorlock1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DOORLOCK, UtasDeviceNo.NO_1,
				UtasDeviceZone.ENTRANCE, function);
	}
	
	public static UtasPacket dehumidifier1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DEHUMIDIFIER, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket dehumidifier2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DEHUMIDIFIER, UtasDeviceNo.NO_2,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket dimming1(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DIMMING, UtasDeviceNo.NO_1,
				UtasDeviceZone.LIVINGROOM, function);
	}
	
	public static UtasPacket lighting2(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.LIGHT, UtasDeviceNo.NO_2,
				UtasDeviceZone.BATHROOM, function);
	}
	
	public static UtasPacket dimming3(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DIMMING, UtasDeviceNo.NO_3,
				UtasDeviceZone.KITCHEN, function);
	}
	
	public static UtasPacket dimming4(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DIMMING, UtasDeviceNo.NO_4,
				UtasDeviceZone.BEDROOM_1, function);
	}
	
	public static UtasPacket dimming5(int function) {
		return new UtasPacket(UtasModbusFC.CONTROL, UtasDeviceType.DIMMING, UtasDeviceNo.NO_5,
				UtasDeviceZone.BEDROOM_2, function);
	}
}
