package kr.kw.data;

import kr.kw.device.SHHomeAppliance;
import kr.kw.device.SHMirrorTV;
import kr.kw.device.SHSensor;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.DBManager;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.shprotocol.item.MirrorTV;
import re.kr.keti.shprotocol.item.Schedule;
import re.kr.keti.shprotocol.item.Service;
import re.kr.keti.shprotocol.item.Smartphone;

public class DataCollector {
	private static final String TAG = "DataCollector";

	private WorkingMemory wkmm;
	private DBManager dbm;

	public DataCollector(WorkingMemory wkmm, DBManager dbm) {
		this.wkmm = wkmm;
		this.dbm = dbm;
	}

	/**
	 * 맥스포 센서 데이터 수집
	 * 
	 * 1. 워킹메모리에 임시로 저장
	 * 2. 디비에 저장
	 * 
	 * @param sensroPacket 맥스포 패킷
	 * */
	public SHSensor collect(SHSensor newSensor) {
		// change a sensor state which is in working memory
		SHSensor sensor = wkmm.getSensorManager().chageState(newSensor);

		// if a sensor is not stored in working memory, store it temporarily
		if(sensor == null) {
			sensor = wkmm.getSensorManager().register(newSensor);		
			if(sensor == null) {
				KWLOG.debug(TAG, "unknown sensor");
			} else {
				KWLOG.debug(TAG, "register a new sensor");
			}
		} else {
			KWLOG.debug(TAG, "maxfor sensor state changed");
		}

		// store in database persistently
		if(sensor != null) {
			if(dbm.getSensorDB().insert(sensor) > 0) {
				KWLOG.debug(TAG, "success to store a sensor in database");
				return sensor;
			} else {
				KWLOG.debug(TAG, "fail to store a sensor in database");
			}
		}

		return null;
	}

	/**
	 * 유타스 가전기기 데이터 수집
	 * 
	 * 1. 워킹메모리에 임시로 저장
	 * 2. 디비에 저장
	 * 
	 * @param device 가전기기 type을 구분하기 위한 값
	 * @param deviceNo 가전기기를 구분하기 위한 값
	 * @param zone 가전기기 위치
	 * @param func 가전기기 기능
	 * */
	public SHHomeAppliance collect(SHHomeAppliance newHa) {
		// change a home appliance which is in working memory
		SHHomeAppliance ha = wkmm.getHAManager().changeState(newHa);		

		// if a home appliance is not stored in working memory, store it temporarily
		if(ha == null) {
			ha = wkmm.getHAManager().register(newHa);
			if(ha == null) {
				KWLOG.debug(TAG, "unknown home appliance");
			}
		} else {
			KWLOG.debug(TAG, "utas home appliance func changed");
		}

		// store in database persistently
		if(ha != null) {
			ha.mapping();
			if(dbm.getHaDB().insert(ha) > 0) {
				KWLOG.debug(TAG, "success to store a home appliance in database");
				return ha;
			} else {
				KWLOG.debug(TAG, "fail to store a home appliance in database");
			}
		}
		

		return null;
	}

	public Schedule collect(Schedule schedule) {
		if(schedule != null) {
			if(dbm.getScheduleDB().insert(schedule)) {
				KWLOG.debug(TAG, "success to store a schedule");
				return schedule;
			} else {
				KWLOG.debug(TAG, "fail to store a schedule");
			}
		}
		
		return null;
	}

	public Smartphone collect(Smartphone smartphone) {
		if(smartphone != null) {
			if(dbm.getSmartphoneDB().insert(smartphone)) {
				KWLOG.debug(TAG, "success to store a smartphone");
				return smartphone;
			} else {
				KWLOG.debug(TAG, "fail to store a smartphone");
			}
		}

		return null;
	}
	
	public Service collect(Service service) {
		if(service != null) {
			if(dbm.getServiceDB().insert(service)) {
				KWLOG.debug(TAG, "success to store a service");
				return service;
			} else {
				KWLOG.debug(TAG, "fail to store a service");
			}
		}

		return null;
	}
	
	public MirrorTV collect(SHMirrorTV mtv) {
		if(mtv != null) {
			wkmm.getMirrorTVManager().register(mtv);
			KWLOG.debug(TAG, "success to store a mirror TV");
		}
		
		return mtv;
	}
}
