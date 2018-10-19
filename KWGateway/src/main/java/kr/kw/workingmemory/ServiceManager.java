package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Service;

public class ServiceManager {
	private static final String TAG = "ServiceManager";
	
	private Map<String, Service> services;
	
	public ServiceManager() {
		services = new HashMap<String, Service>();
	}
	
	public void add(Service service) {
		services.put(service.getSvid(), service);
		KWLOG.debug(TAG, "add: " + service.toString());
	}
	
	public List<Service> getServices() {
		Iterator<Service> mi = services.values().iterator();
		List<Service> list = new ArrayList<Service>();
		for(@SuppressWarnings("unused")
		Iterator<Service> i = mi; mi.hasNext(); ) {
			Service e = mi.next();
			list.add(e);
		}
		
		return list;
	}
}
