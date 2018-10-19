package kr.kw.service.contextawareness.arff;

import re.kr.keti.shprotocol.item.Service;

public interface ARFF {
	public String getFile();
	
	public void setService(Service service);
	
	public Service getService();
	
	public int getLocation();
}
