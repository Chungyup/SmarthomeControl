package re.kr.keti.lcy.device.maxfor.packet;

import java.util.HashMap;
import java.util.Map;

public class MaxforPacketManager {
	private Map<String, MaxforPacketBuffer> packetBuffers;
	
	public MaxforPacketManager() {
		packetBuffers = new HashMap<String, MaxforPacketBuffer>();
	}
	
	public MaxforPacketBuffer addBuffer(String key) {
		MaxforPacketBuffer buffer = new MaxforPacketBuffer();
		packetBuffers.put(key, buffer);
		return buffer;
	}
	
	public MaxforPacketBuffer getBuffer(String key) {
		return packetBuffers.get(key);
	}
	
	public boolean isBuffer(String key) {
		return packetBuffers.containsKey(key);
	}
}
