package kr.kw.user;

import kr.kw.device.SHSensor;
import kr.kw.gateway.KWGateway;
import re.kr.keti.lcy.device.maxfor.item.MaxforLocationTag;
import re.kr.keti.shprotocol.item.User;

public class GWUser extends User {
	private int prelocation;
	private int currentReaderId;
	private SHSensor tag;

	public GWUser() {}

	public GWUser(String phnb, String name, String afl, String ofc, String type, SHSensor tag) {
		super(phnb, name, afl, ofc, type, null, null);
		this.tag = tag;
		super.tagid = tag.getDeviceId();
		
		prelocation = 0;
		currentReaderId = 0;

		gwid = KWGateway.ID;
	}
	
	public boolean has(int tagId) {
		return tag.getDeviceId() == tagId;
	}

	public int getTagId() {
		return tag.getDeviceId();
	}
	
	public int getPreLoc() {
		return prelocation;
	}
	
	public int getCurLoc() {
		return currentReaderId;
	}
	
	public boolean changeLocation() {
		if(currentReaderId != getTag().getReaderId()) {
			prelocation = currentReaderId;
			currentReaderId = getTag().getReaderId();
			return true;
		}
		
		return false;
	}
	
	public MaxforLocationTag getTag() {
		return (MaxforLocationTag) tag.getSensorState();
	}

}
