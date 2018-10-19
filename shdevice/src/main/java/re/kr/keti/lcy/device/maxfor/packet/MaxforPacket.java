package re.kr.keti.lcy.device.maxfor.packet;

import java.util.Arrays;

import re.kr.keti.lcy.util.Utils;

public class MaxforPacket {
	private final static int HEADER_SIZE = 4;

	// HEADER
	private int deviceGroup;
	private int deviceId;

	// PAYLOAD
	private int payloadLength;
	private Byte[] payload;
	
	public MaxforPacket(byte[] packet) {
		deviceGroup = packet[2];
		
		deviceId = Utils.makeByteArraytoInt(packet[3], packet[4]);	

		payloadLength = packet[1];
		payload = new Byte[payloadLength];
		copyPayload(packet);
//		System.arraycopy(packet, HEADER_SIZE+1, payload, 0, payloadLength);
	}
	
	private void copyPayload(byte[] packet) {
		for(int i=0; i<payloadLength; i++) {
			payload[i] = packet[HEADER_SIZE + 1 + i];
		}
	}
	

	public int getDeviceGroup() {
		return deviceGroup;
	}

	public void setDeviceGroup(byte deviceGroup) {
		this.deviceGroup = deviceGroup;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(byte deviceId) {
		this.deviceId = deviceId;
	}

	public Byte[] getPayload() {
		return payload;
	}

	public void setPayload(Byte[] payload) {
		this.payload = payload;
	}
	
	public static boolean isValid(byte[] packet, int length) {
		return packet != null && length > 0;
	}
	
	public static boolean isDummy(byte[] packet) {
		return packet == null ? true : packet.length <= 0;
	}

	@Override
	public String toString() {
		return "MaxforPacket [deviceGroup=" + deviceGroup + ", deviceId=" + deviceId + ", payloadLength="
				+ payloadLength + ", payload=" + Arrays.toString(payload) + "]";
	}
}
