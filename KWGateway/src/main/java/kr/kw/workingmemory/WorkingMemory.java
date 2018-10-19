package kr.kw.workingmemory;

public class WorkingMemory {
	private static WorkingMemory instance = null;
	public static WorkingMemory getInstance() {
		if(instance == null) {
			instance = new WorkingMemory();
		}
		
		return instance;
	}
	
	private UserManager userManager;
	private SensorManager sensorManager;
	private HomeApplianceManager haManager;
	private MirrorTVManager mtvManager;
	private ServiceManager serviceManager;
	private MashupManager mashupManager;
	
	private WorkingMemory() {
		userManager = new UserManager();
		sensorManager = new SensorManager();
		haManager = new HomeApplianceManager();
		mtvManager = new MirrorTVManager();
		serviceManager = new ServiceManager();
		mashupManager = new MashupManager();
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public SensorManager getSensorManager() {
		return sensorManager;
	}
	
	public HomeApplianceManager getHAManager() {
		return haManager;
	}
	
	
	public MirrorTVManager getMirrorTVManager() {
		return mtvManager;
	}
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	
	public MashupManager getMashupManager() {
		return mashupManager;
	}

//	@Override
//	public String toString() {
//		return "WorkingMemory [maxforSensorManager=" + maxforSensorManager.toString() 
//			+ ", utasHAManager=" + utasHAManager.toString() + ", userManager" + userManager.toString() + "]";
//	}

	@Override
	public String toString() {
		String info = "";
		
		info += "** USER\n\t";
		info += userManager.toString();
		
		info += "\n** SENSOR\n\t";
		
		info += sensorManager.toString();
		
		info += "\n** HOME APPLIANCE\n\t";
		
		info += haManager.toString() + "\n";
		
		return info;
	}
}
