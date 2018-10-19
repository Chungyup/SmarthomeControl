package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.List;

import kr.kw.device.SHHomeAppliance;
import re.kr.keti.lcy.device.HAFunction;
import re.kr.keti.lcy.device.utas.item.UtasHAFactory;

public class HomeApplianceManager {
	private List<SHHomeAppliance> homeappliances;

	public HomeApplianceManager() {
		homeappliances = new ArrayList<SHHomeAppliance>();
	}
	
	public SHHomeAppliance changeState(SHHomeAppliance newha) {
		if(newha != null) {
			for (SHHomeAppliance uha : homeappliances) {
				if (newha.getDevice() == uha.getDevice() && newha.getDeviceNo() == uha.getDeviceNo()) {
					uha.getHAFunction().updateFunction(newha.getHAFunction().getFunction());
					uha.getHAFunction().updateSpecial(newha.getHAFunction().getSpecial());
					return uha;
				}
			}	
		}

		return null;
	}

	public SHHomeAppliance register(SHHomeAppliance ha) {
		if(ha != null) {
			homeappliances.add(ha);
			return ha;
		}
		
		return null;
	}
	
	public boolean isWorking(int device, int deviceNo, int zone, int func) {

		for (SHHomeAppliance ha : homeappliances) {
			if (device == ha.getDevice() 
					&& deviceNo == ha.getDeviceNo()
					&& zone == ha.getZone()
					&& (func == ha.getOnOff()
					|| func == ha.getHAFunction().getFunction())) {
				
				return true;
			}
		}
		return false;
	}
	
	public SHHomeAppliance register(int device, int deviceNo, int zone, int func) {
		HAFunction function = UtasHAFactory.makeHAFunction(device);
		
		if (function != null) {
			SHHomeAppliance ha = new SHHomeAppliance(device, deviceNo, zone, function);
//			ha.updateCommonFunction(func);
			ha.getHAFunction().updateFunction(func);
			
			homeappliances.add(ha);
//			KWLOG.debug(TAG, ha.toString());
			return ha;
		}

		return null;
	}
	
	public boolean equalOnOff(int device, int deviceN, int func) {
		for (SHHomeAppliance ha : homeappliances) {
			if(ha.getDevice() == device && ha.getDeviceNo() == deviceN) {
				return ha.getHAFunction().equalOnOff(func);
			}
		}
		
		return false;
	}
	
	
	public List<SHHomeAppliance> getHomeAppliances() {
		return homeappliances;
	}
	
	@Override
	public String toString() {
		String haList = "";
		for (SHHomeAppliance ha : homeappliances) {
			haList += ha.toString() + "\n\t";
		}
		return haList;
	}
}
