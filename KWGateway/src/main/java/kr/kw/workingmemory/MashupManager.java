package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Service;

public class MashupManager {
	private static final String TAG = "MashupManager";
	
	private Map<String, Service> services;
	
	public MashupManager() {
		services = new HashMap<String, Service>();
	}
	
	public void add(Service service) {
		services.put(service.getSvid(), service);
		KWLOG.debug(TAG, "add: " + service.toString());
	}
	
	public void delete(Service service) {
		services.remove(service.getSvid());
		KWLOG.debug(TAG, "delete: " + service.toString());
	}
	
	public void put(List<Service> serviceList) {
		services.clear();
		for(Service service : serviceList) {
			services.put(service.getSvid(), service);
		}
		KWLOG.debug(TAG, "put: " + serviceList.toString());
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
