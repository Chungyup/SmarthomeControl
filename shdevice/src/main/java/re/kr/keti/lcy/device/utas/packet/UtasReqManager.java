package re.kr.keti.lcy.device.utas.packet;

import java.util.ArrayList;
import java.util.List;

public class UtasReqManager {
	public UtasReqManager() {
		reqPackets = new ArrayList<UtasPacket>();
	}

	private List<UtasPacket> reqPackets;

	public void addReqPacket(UtasPacket packet) {
		if (reqPackets != null) {
			reqPackets.add(packet);
		}
	}

	public UtasPacket findReqPacket(int device, int deviceNo) {
		if (reqPackets != null) {
			for(UtasPacket packet : reqPackets) {
				if (packet.same(device, deviceNo)) {
					reqPackets.remove(packet);
					return packet;
				}
			}
//			for (int i = 0; i < reqPackets.size(); i++) {
//				UtasPacket packet = reqPackets.get(i);
//
//				// System.out.println("REQPACKET: " + "device=" +
//				// packet.getDevice() + ", deviceNo=" + packet.getDeviceNo());
//				if (packet.same(device, deviceNo)) {
//					reqPackets.remove(i);
//					return packet;
//				}
//			}

		}

		return null;
	}
}
