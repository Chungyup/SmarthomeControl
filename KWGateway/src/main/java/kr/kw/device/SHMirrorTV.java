package kr.kw.device;

import java.util.List;

import kr.kw.user.GWUser;
import kr.re.keti.socket.KETIServerSocket.KETIClient;
import re.kr.keti.shprotocol.item.MirrorTV;

public class SHMirrorTV extends MirrorTV {

	private KETIClient client;
	
	public SHMirrorTV(KETIClient client, MirrorTV mtv) {
		this.client = client;
		setMrid(mtv.getMrid());
		setMrloc(mtv.getMrloc());	
	}
	
	public SHMirrorTV(KETIClient client) {
		this.client = client;
	}

	public KETIClient getClient() {
		return client;
	}
	
	public void setCount(List<GWUser> users) {
		int count = 0;
		for(GWUser user : users) {
			if(getMrloc() == user.getTag().getReaderId()) {
				count++;
			}
		}

		this.setBrtn(count);
	}

	
	
	
}