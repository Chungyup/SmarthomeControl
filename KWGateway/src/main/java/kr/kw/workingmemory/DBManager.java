package kr.kw.workingmemory;

import kr.kw.database.DAOGateway;
import kr.kw.database.DAOHomeAppliance;
import kr.kw.database.DAOSchedule;
import kr.kw.database.DAOSensor;
import kr.kw.database.DAOService;
import kr.kw.database.DAOSmartphone;
import kr.kw.database.DAOUser;
import kr.kw.database.SessionFactory;

public class DBManager {
	public static DBManager instance = null;
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		
		return instance;
	}
	
	private DAOGateway gatewayDB;
	private DAOHomeAppliance haDB;
	private DAOSensor snesorDB;
	private DAOService serviceDB;
	private DAOUser userDB;
	private DAOSchedule scheduleDB;
	private DAOSmartphone smartphoneDB;

	private DBManager() {
		gatewayDB = new DAOGateway(SessionFactory.getServiceSession());
		haDB = new DAOHomeAppliance(SessionFactory.getServiceSession());
		snesorDB = new DAOSensor(SessionFactory.getServiceSession());
		serviceDB = new DAOService(SessionFactory.getServiceSession());
		userDB = new DAOUser(SessionFactory.getServiceSession());
		scheduleDB = new DAOSchedule(SessionFactory.getServiceSession());
		smartphoneDB = new DAOSmartphone(SessionFactory.getServiceSession());
	}
	
	public DAOGateway getGatewayDB() {
		return gatewayDB;
	}
	
	public DAOHomeAppliance getHaDB() {
		return haDB;
	}
	
	public DAOSensor getSensorDB() {
		return snesorDB;
	}
	
	
	public DAOService getServiceDB() {
		return serviceDB;
	}
	
	public DAOUser getUserDB() {
		return userDB;
	}
	
	public DAOSchedule getScheduleDB() {
		return scheduleDB;
	}
	
	public DAOSmartphone getSmartphoneDB() {
		return smartphoneDB;
	}
}
