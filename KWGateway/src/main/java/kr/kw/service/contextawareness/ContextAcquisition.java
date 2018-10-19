package kr.kw.service.contextawareness;

import java.util.Map;

import kr.kw.gateway.KWGateway;
import kr.kw.service.contextawareness.arff.ARFF;
import kr.kw.service.contextawareness.arff.Building1ARFF;
import kr.kw.service.contextawareness.arff.Building5ARFF;
import kr.kw.service.contextawareness.arff.Building6ARFF;
import kr.kw.service.contextawareness.arff.Building7ARFF;
import kr.kw.service.contextawareness.arff.HomeARFF;
import kr.kw.service.floor1.F1HAService;
import kr.kw.service.floor1.F1LightService;
import kr.kw.service.floor5.F5DoorlockService;
import kr.kw.service.floor5.F5HAService;
import kr.kw.service.floor5.F5LightService;
import kr.kw.service.floor6.F6DoorlockService;
import kr.kw.service.floor6.F6HAService;
import kr.kw.service.floor6.F6LightService;
import kr.kw.service.floor7.F7DoorlockService;
import kr.kw.service.floor7.F7HAService;
import kr.kw.service.floor7.F7LightService;
import kr.kw.service.home.Bathroom;
import kr.kw.service.home.Bedroom1;
import kr.kw.service.home.Bedroom2;
import kr.kw.service.home.Bedroom2Heater;
import kr.kw.service.home.Entry;
import kr.kw.service.home.Kitchen;
import kr.kw.service.home.Livingroom;
import kr.kw.service.home.Outside;
import kr.kw.service.home.SleepWakeup;
import kr.kw.service.home.TVZone;
import kr.kw.user.GWUser;
import kr.kw.workingmemory.WorkingMemory;
import kr.kw.zone.Zone;
import re.kr.keti.lcy.device.maxfor.item.MaxforLocationTag;

public class ContextAcquisition {
	public Relation obtain(final GWUser user, ARFF service, WorkingMemory wm) {
		if("home".equals(KWGateway.LOCATION)) {
			if("6".equals(KWGateway.FLOOR)) {
				return obtain(user, (HomeARFF) service, wm);
			}
		}
		
		else if("building".equals(KWGateway.LOCATION)) {
			if("1".equals(KWGateway.FLOOR)) {
				return obtain(user, (Building1ARFF) service, wm);
			} else if("5".equals(KWGateway.FLOOR)) {
				return obtain(user, (Building5ARFF) service, wm);
			} else if("6".equals(KWGateway.FLOOR)) {
				return obtain(user, (Building6ARFF) service, wm);
			} else if("7".equals(KWGateway.FLOOR)) {
				return obtain(user, (Building7ARFF) service, wm);
			}
		}
		
		return null;
	}
	
	private Relation obtain(final GWUser user, HomeARFF service, WorkingMemory wm) {
		
		Map<Integer, Integer> users = wm.getSensorManager().getUsers();
		int prelocation = -1;
		if(user != null) {
			prelocation = user.getPreLoc();
		}
		int user11 = users.get(11);
		int user12 = users.get(12);
		int user13 = users.get(13);
		
		switch (service) {
		case BATHROOM:
			Bathroom bathroom = new Bathroom(prelocation, user11, user12, user13);
			
			return bathroom;
			
		case BEDROOM1:
			Bedroom1 bedroom1 = new Bedroom1(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return bedroom1;
			
		case BEDROOM2:
			Bedroom2 bedroom2 = new Bedroom2(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return bedroom2;
			
		case KITCHEN:
			Kitchen kitchen = new Kitchen(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return kitchen;
			
		case LIVINGROOM:
			Livingroom livingroom = new Livingroom(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return livingroom;
		case ENTRY:
			Entry entry = new Entry(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return entry;
			
		case OUTSIDE:
			Outside outside = new Outside(prelocation, user11, user12, user13);
			
			return outside;
		
		case SLEEPWAKEUP:
			SleepWakeup sleepwakeup = new SleepWakeup(prelocation, user11, user12, user13, Zone.pressure(wm));
			
			return sleepwakeup;
			
		case TVZONE:
			TVZone tvzone = new TVZone(prelocation, user11, user12, user13);
			
			return tvzone;
			
		case HEATER:
			Bedroom2Heater heater = new Bedroom2Heater(prelocation, user11, user12, user13,
					Zone.temperature(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.humidity(MaxforLocationTag.LOCATION_LIVINGROOM, wm),
					Zone.co2(MaxforLocationTag.LOCATION_LIVINGROOM, wm));
			
			return heater;
			
		default:
			break;
		}

		return null;
	}
	
	private Relation obtain(final GWUser user, Building1ARFF service, WorkingMemory wm) {
		int uid = -1;
		int loc = -1;
		
		if(user != null) {
			uid = user.getTag().getTagId();
			loc = user.getTag().getReaderId();
		}
		switch (service) {
		case HA:
			F1HAService ha = new F1HAService(uid, loc, Zone.temperature(MaxforLocationTag.LOCATION_1F, wm));
			return ha;
			
		case LIGHT:
			F1LightService light = new F1LightService(uid, loc);
			return light;
			
		}

		return null;
	}
	
	private Relation obtain(final GWUser user, Building5ARFF service, WorkingMemory wm) {
		int uid = -1;
		int loc = -1;
		
		if(user != null) {
			uid = user.getTag().getTagId();
			loc = user.getTag().getReaderId();
		}
		switch (service) {
		case HA:
			F5HAService ha = new F5HAService(uid, loc, Zone.temperature(MaxforLocationTag.LOCATION_5F, wm));
			return ha;
			
		case LIGHT:
			F5LightService light = new F5LightService(uid, loc);
			return light;
			
		case DOORLOCK:
			F5DoorlockService doorlock = new F5DoorlockService(uid, loc);
			return doorlock;
		}

		return null;
	}
	
	private Relation obtain(final GWUser user, Building6ARFF service, WorkingMemory wm) {
		int uid = -1;
		int loc = -1;
		
		if(user != null) {
			uid = user.getTag().getTagId();
			loc = user.getTag().getReaderId();
		}
		
		switch (service) {
		case HA:
			F6HAService ha = new F6HAService(uid, loc, Zone.temperature(MaxforLocationTag.LOCATION_6F, wm));
			return ha;
			
		case LIGHT:
			F6LightService light = new F6LightService(uid, loc);
			return light;
			
		case DOORLOCK:
			F6DoorlockService doorlock = new F6DoorlockService(uid, loc);
			return doorlock;
		}

		return null;
	}
	
	private Relation obtain(final GWUser user, Building7ARFF service, WorkingMemory wm) {
		int uid = -1;
		int loc = -1;
		
		if(user != null) {
			uid = user.getTag().getTagId();
			loc = user.getTag().getReaderId();
		}
		
		switch (service) {
		case HA:
			F7HAService ha = new F7HAService(uid, loc, Zone.temperature(MaxforLocationTag.LOCATION_7F, wm));
			return ha;
			
		case LIGHT:
			F7LightService light = new F7LightService(uid, loc);
			return light;
			
		case DOORLOCK:
			F7DoorlockService doorlock = new F7DoorlockService(uid, loc);
			return doorlock;
		}

		return null;
	}

}
