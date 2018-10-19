package re.kr.keti.lcy.device.utas.packet;

import java.util.Arrays;

/***
 * 
 * WEITRE PACKET
 * 	transaction ID
 * 		[00] [00] 	
 * 	protocol ID
 * 		[00] [00] 
 * 
 * 	DATA
 * 		length
 * 			[00] [09] 
 * 		unit ID
 * 			[00] 
 * 		MODBUS FC
 * 			[10] 
 * 		Reference number
 * 			device
 * 				[00] 
 * 			device No
 * 				[00] 
 * 		word count
 * 			[00] [01] [02]
 * 		register values
 * 			[0~FF] [0~FF]
 * 
 * **/

public class UtasPacket {
	
	private int modbusFC;
	private int device;
	private int deviceNo;
	private int zone;
	private int function;
	private int special;
	
	public UtasPacket() {
		
	}
	
	public UtasPacket(int device, int deviceNo, int zone, int function) {
		this.device = device;
		this.deviceNo = deviceNo;
		this.zone = zone;
		this.function = function;
	}
	
	public UtasPacket(byte[] packet) {
		this.device = UtasPacket.getDevice(packet);
		this.deviceNo = UtasPacket.getDeviceNo(packet);
		int length = packet[12];
		this.zone = packet[13];
		this.function = packet[14];
		if(length == 3) {
			System.out.println("SPECIAL.....");
			this.special = packet[15];
		}
	}
	
	public UtasPacket(int modbusFC, int device, int deviceNo, int zone, int function) {
		this.modbusFC = modbusFC;
		this.device = device;
		this.deviceNo = deviceNo;
		this.zone = zone;
		this.function = function;
	}

	public boolean same(int device, int deviceNo) {
		return this.device == device && this.deviceNo == deviceNo;
	}

	/**
	 * make a control packet
	 * 
	 * @return packet
	 * */
	public static byte[] makeCtrWrite(byte deviceType, byte deviceNo, byte zone, byte function) {
		// pack size: 15
		byte[] onPacket = new byte[15];
		Arrays.fill(onPacket, (byte) 0);
		
		// length
		onPacket[5] = 0x09;
	
		// MODBUS FC
		onPacket[7] = 0x10;
		
		// Device
		onPacket[8] = deviceType;
		// Device No.
		onPacket[9] = deviceNo;
		
		// FIX: word count 
		onPacket[10] = 0x00;
		onPacket[11] = 0x01;
		// FIX : byte count
		onPacket[12] = 0x02;
		
		// zone
		onPacket[13] = zone;
		
		// device function
		onPacket[14] = function;
		
		
		return onPacket;
	}
	
	public byte[] makeCtrWrite() {
		// pack size: 15
		byte[] onPacket = new byte[15];
		Arrays.fill(onPacket, (byte) 0);
		
		// length
		onPacket[5] = 0x09;
	
		// MODBUS FC
		onPacket[7] = 0x10;
		
		// Device
		onPacket[8] = (byte) device;
		// Device No.
		onPacket[9] = (byte) deviceNo;
		
		// FIX: word count 
		onPacket[10] = 0x00;
		onPacket[11] = 0x01;
		// FIX : byte count
		onPacket[12] = 0x02;
		
		// zone
		onPacket[13] = (byte) zone;
		
		// device function
		onPacket[14] = (byte) function;
		
		
		return onPacket;
	}
	
	/**
	 * make a packet to get all home appliance's states
	 *
	 * @return packet
	 * */
	public byte[] makeAllHAStatesWrite() {
		byte[] onPacket = new byte[12];
		Arrays.fill(onPacket, (byte) 0);
		
		// length
		onPacket[5] = 0x06;
		
		// MODBUS FC
		onPacket[7] = 0x03;
		
		// start address value
		onPacket[9] = 0x01;
		
		// end address value
		onPacket[11] = 0x12;
		
		return onPacket;
	}
	
	
	/**
	 * make a packet to get a home appliance's states
	 * 
	 * @return packet
	 * */
	public byte[] makeStateCheckWrite() {
		byte[] onPacket = new byte[6];
		Arrays.fill(onPacket, (byte) 0);
		
		// length
		onPacket[5] = 0x06;
			
		// MODBUS FC
		onPacket[7] = 0x03;
				
//		// Device
//		onPacket[8] = deviceType;
//				// Device No.
//		onPacket[9] = deviceNo;
				
		
		return onPacket;
	}
	
	public int getModbudFC() {
		return modbusFC;
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
	
	public int getFunction() {
		return function;
	}
	
	public int getSpecial() {
		return special;
	}
	
	public static int getDevice(byte[] packet) {
		int device = -1;
		try {
			device = packet[8];
		} catch(IndexOutOfBoundsException e) {
			System.out.println("getDevice: " + "out of index");
		}
		
		return device;
	}
	
	public static int getDeviceNo(byte[] packet) {
		int deviceNo = -1;
		try {
			deviceNo = packet[9];
		} catch(IndexOutOfBoundsException e) {
			System.out.println("getDevice: " + "out of index");
		}
		
		return deviceNo;
	}
	
	
	public static boolean isValid(byte[] packet, int length) {
		return packet != null && length > 0;
	}
}
