package kr.kw.service;

import re.kr.keti.shprotocol.item.Service;

public class GWService extends Service {
	public static boolean use = false;
	public static String type = "";
	public static String service = "";

	private boolean onOff;

	public GWService() {
		onOff = false;
	}

	public boolean isOnOff() {
		return onOff;
	}

	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}

}
