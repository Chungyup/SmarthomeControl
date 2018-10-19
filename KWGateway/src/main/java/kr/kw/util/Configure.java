package kr.kw.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import kr.kw.connect.Address;
import kr.kw.connect.Connector;
import kr.kw.connect.Port;
import kr.kw.connect.Serial;
import kr.kw.database.SessionFactory;
import kr.kw.device.DeviceFactory;
import kr.kw.device.SHSensor;
import kr.kw.gateway.KWGateway;
import kr.kw.service.GWService;

public class Configure {
	private static final String TAG ="Configure";
	
	private static final String PROP_FILENAME = "configure.properties";
	
	public void setConfig() {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(PROP_FILENAME);
			if(input != null) {
				prop.load(input);
				input.close();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		configLog(prop);
		configDB(prop);
		configGateway(prop);
		configBMS(prop);
		configGWService(prop);
		configSensor(prop);
		configHA(prop);
		configService(prop);
		configFilterSensor(prop);
	}
	
	private void configDB(Properties prop) {
		KWLOG.info(TAG, "*** database configuration");
		String url =  prop.getProperty("db_url");
		if(url != null && !"".equals(url)) {
			System.out.println("\tset url: " + url);
		}
		
		String db =  prop.getProperty("db_name");
		if(db != null && !"".equals(db)) {
			System.out.println("\tset db: " + db);
		}
		
		String username =  prop.getProperty("db_username");
		if(username != null && !"".equals(username)) {
			System.out.println("\tset username: " + username);
		}
		
		String password =  prop.getProperty("db_password");
		if(password != null && !"".equals(password)) {
			System.out.println("\tset password: " + password);
		}
		
		SessionFactory.setting(url, db, username, password);
	}
	
	private void configGateway(Properties prop) {
		KWLOG.info(TAG, "*** gateway configuration");
		String gatewayId =  prop.getProperty("gateway_id");
		if(gatewayId != null && !"".equals(gatewayId)) {
			KWGateway.ID = gatewayId;
			System.out.println("\tset id: " + gatewayId);
		}
		
		String building =  prop.getProperty("gateway_building");
		if(building != null && !"".equals(building)) {
			KWGateway.BUIlDING = building;
			System.out.println("\tset building: " + building);
		}
		
		String floor =  prop.getProperty("gateway_floor");
		if(floor != null && !"".equals(floor)) {
			KWGateway.FLOOR = floor;
			System.out.println("\tset floor: " + floor);
		}
		
		String location =  prop.getProperty("gateway_location");
		if(location != null && !"".equals(location)) {
			KWGateway.LOCATION = location;
			System.out.println("\tset location: " + location);
		}
	}
	
	private void configBMS(Properties prop) {
		String useBMSClient =  prop.getProperty("bms_client_use");
		if(useBMSClient != null && "yes".equals(useBMSClient)) {
			Connector.USE_BMS_CLIENT = true;
			System.out.println("\tset BMS client use: " + useBMSClient);
		} else if(useBMSClient != null && "no".equals(useBMSClient)) {
			Connector.USE_BMS_CLIENT = false;
			System.out.println("\tset BMS client use: " + useBMSClient);
		}
		
		String bmsServerIp =  prop.getProperty("bms_server_ip");
		if(bmsServerIp != null && !"".equals(bmsServerIp)) {
			Address.BMS_SERVER = bmsServerIp;
			System.out.println("\tset BMS server ip: " + bmsServerIp);
		}

		String bmsServerPort = prop.getProperty("bms_server_port");
		if(bmsServerPort != null && !"".equals(bmsServerPort)) {
			Port.BMS_PORT = Integer.valueOf(bmsServerPort);
			System.out.println("\tset BMS server port: " + bmsServerPort);
		}
	}
	
	private void configGWService(Properties prop) {
		KWLOG.info(TAG, "*** context-awareness configuration");
		String contextAwareness =  prop.getProperty("scenario_use");
		if(contextAwareness != null && "yes".equals(contextAwareness)) {
			GWService.use = true;
			System.out.println("\tcontext-awareness use: " + contextAwareness);
		} else if(contextAwareness != null && "no".equals(contextAwareness)) {
			GWService.use = false;
			System.out.println("\tcontext-awareness use: " + contextAwareness);
		}
		
		String contextAwarenessType = prop.getProperty("scenario_type");
		if(contextAwarenessType != null && !"".equals(contextAwarenessType)) {
			GWService.type = contextAwarenessType;
			System.out.println("\tcontext-awareness type: " + contextAwarenessType);
		}
		
		String contextAwarenessService = prop.getProperty("scenario_service");
		if(contextAwarenessService != null && !"".equals(contextAwarenessService)) {
			GWService.service = contextAwarenessService;
			System.out.println("\tcontext-awareness service: " + contextAwarenessService);
		}
	}
	
	private void configSensor(Properties prop) {
		KWLOG.info(TAG, "*** sensor configuration");
		
		String useSensorServer =  prop.getProperty("sensor_server_use");
		if(useSensorServer != null && "yes".equals(useSensorServer)) {
			Connector.USE_SENSOR_SERVER = true;
			System.out.println("\tset sensor use: " + useSensorServer);
		} else if(useSensorServer != null && "no".equals(useSensorServer)) {
			Connector.USE_SENSOR_SERVER = false;
			System.out.println("\tset sensor use: " + useSensorServer);
		}
		
		String sensorPort = prop.getProperty("sensor_server_port");
		if(sensorPort != null && !"".equals(sensorPort)) {
			Port.SENSOR_PORT = Integer.valueOf(sensorPort);
			System.out.println("\tset sensor port: " + sensorPort);
		}
		
		
		String useSensorSerial =  prop.getProperty("sensor_serial_use");
		if(useSensorSerial != null && "yes".equals(useSensorSerial)) {
			Connector.USE_SERIAL = true;
			System.out.println("\tset serial use: " + useSensorSerial);
		} else if(useSensorSerial != null && "no".equals(useSensorSerial)) {
			Connector.USE_SERIAL = false;
			System.out.println("\tset serial use: " + useSensorSerial);
		}
		
		String sensorSerialPort = prop.getProperty("sensor_serial_port");
		if(sensorSerialPort != null && !"".equals(sensorSerialPort)) {
			Serial.PORT = sensorSerialPort;
			System.out.println("\tset serial port name: " + sensorSerialPort);
		}
		
		String sensorSerialBaudrate= prop.getProperty("sensor_serial_baudrate");
		if(sensorSerialBaudrate != null && !"".equals(sensorSerialBaudrate)) {
			Serial.BAUDRATE = Integer.valueOf(sensorSerialBaudrate);
			System.out.println("\tset serial baudrate: " + sensorSerialBaudrate);
		}
	}
	
	private void configHA(Properties prop) {
		KWLOG.info(TAG, "*** home appliance configuration");
		
		String useHAClient =  prop.getProperty("ha_client_use");
		if(useHAClient != null && "yes".equals(useHAClient)) {
			Connector.USE_HA_CLIENT = true;
			System.out.println("\tset HA client use: " + useHAClient);
		} else if(useHAClient != null && "no".equals(useHAClient)) {
			Connector.USE_HA_CLIENT = false;
			System.out.println("\tset HA client use: " + useHAClient);
		}
		
		String useHAServer =  prop.getProperty("ha_server_use");
		if(useHAServer != null && "yes".equals(useHAServer)) {
			Connector.USE_HA_SERVER = true;
			System.out.println("\tset HA server use: " + useHAServer);
		} else if(useHAServer != null && "no".equals(useHAServer)) {
			Connector.USE_HA_SERVER = false;
			System.out.println("\tset HA server use: " + useHAServer);
		}
		
		String haServerIp =  prop.getProperty("ha_server_ip");
		if(haServerIp != null && !"".equals(haServerIp)) {
			Address.HA_SERVER = haServerIp;		
			System.out.println("\tset HA server ip: " + haServerIp);
		}

		String haServerPort = prop.getProperty("ha_server_port");
		if(haServerPort != null && !"".equals(haServerPort)) {
			Port.HA_CLIENT_PORT = Integer.valueOf(haServerPort);
			System.out.println("\tset HA server port: " + haServerPort);
		}
		
		String haPort = prop.getProperty("ha_port");
		if(haPort != null && !"".equals(haPort)) {
			Port.HA_SERVER_PORT = Integer.valueOf(haPort);
			System.out.println("\tset HA port: " + haPort);
		}
	}
	
	private void configService(Properties prop) {
		KWLOG.info(TAG, "*** service configuration");
		
		// MASH-UP
		String useMashup =  prop.getProperty("mashup_client_use");
		if(useMashup != null && "yes".equals(useMashup)) {
			Connector.USE_MASHUP = true;
			System.out.println("\tset mashup client use: " + useMashup);
		} else if(useMashup != null && "no".equals(useMashup)) {
			Connector.USE_MASHUP = false;
			System.out.println("\tset mashup client use: " + useMashup);
		}
		
		String mashupServerIp = prop.getProperty("mashup_server_ip");
		if(mashupServerIp != null && !"".equals(mashupServerIp)) {
			Address.MASHUP = mashupServerIp;
			System.out.println("\tset mashup server ip: " + mashupServerIp);
		}
		
		String mashupServerPort = prop.getProperty("mashup_server_port");
		if(mashupServerPort != null && !"".equals(mashupServerPort)) {
			Port.MASHUP = Integer.valueOf(mashupServerPort);
			System.out.println("\tset mashup server port: " + mashupServerPort);
		}
		
		// MONITORING
		String useMonitoring =  prop.getProperty("monitoring_server_use");
		if(useMonitoring != null && "yes".equals(useMonitoring)) {
			Connector.USE_MONITORING = true;
			System.out.println("\tset monitoring server use: " + useMonitoring);
		} else if(useMonitoring != null && "no".equals(useMonitoring)) {
			Connector.USE_MONITORING = false;
			System.out.println("\tset monitoring server use: " + useMonitoring);
		}
		
		String monitoringClientPort = prop.getProperty("monitoring_server_port");
		if(monitoringClientPort != null && !"".equals(monitoringClientPort)) {
			Port.MONITORING = Integer.valueOf(monitoringClientPort);
			System.out.println("\tset monitoring server port: " + monitoringClientPort);
		}
		
		// MIRROR TV
		String useMirrorTV =  prop.getProperty("mirrortv_server_use");
		if(useMirrorTV != null && "yes".equals(useMirrorTV)) {
			Connector.USE_MIRRORTV = true;
			System.out.println("\tset mirror TV server use: " + useMirrorTV);
		} else if(useMirrorTV != null && "no".equals(useMirrorTV)) {
			Connector.USE_MIRRORTV = false;
			System.out.println("\tset mirror TV server use: " + useMirrorTV);
		}
		
		String mirrorTVClientPort = prop.getProperty("mirrortv_server_port");
		if(mirrorTVClientPort != null && !"".equals(mirrorTVClientPort)) {
			Port.MIRROTTV = Integer.valueOf(mirrorTVClientPort);
			System.out.println("\tset mirror TV server port: " + mirrorTVClientPort);
		}
		
		String useApp =  prop.getProperty("app_server_use");
		if(useApp != null && "yes".equals(useApp)) {
			Connector.USE_APP = true;
			System.out.println("\tset APP server use: " + useApp);
		} else if(useApp != null && "no".equals(useApp)) {
			Connector.USE_APP = false;
			System.out.println("\tset APP server use: " + useApp);
		}
		
		String appClientPort = prop.getProperty("app_server_port");
		if(appClientPort != null && !"".equals(appClientPort)) {
			Port.APP = Integer.valueOf(appClientPort);
			System.out.println("\tset APP server port: " + appClientPort);
		}
	}
	
	private void configLog(Properties prop) {
		String loghist = prop.getProperty("log_history");
		if(loghist != null && "yes".equals(loghist)) {
			KWLOG.HISTORY = true;
			KWLOG.openFile();
			System.out.println("\tlog loghist: " + loghist);
		} else if(loghist != null && "no".equals(loghist)) {
			KWLOG.HISTORY = false;
			System.out.println("\tlog loghist: " + loghist);
		}
		
		String logi = prop.getProperty("log_i");
		if(logi != null && "yes".equals(logi)) {
			KWLOG.INFO = true;
			System.out.println("\tlog info: " + logi);
		} else if(logi != null && "no".equals(logi)) {
			KWLOG.INFO = false;
			System.out.println("\tlog info: " + logi);
		}
		
		String logd = prop.getProperty("log_d");
		if(logd != null && "yes".equals(logd)) {
			KWLOG.DEBUG = true;
			System.out.println("\tlog debug: " + logd);
		} else if(logd != null && "no".equals(logd)) {
			KWLOG.DEBUG = false;
			System.out.println("\tlog debug: " + logd);
		}
		
		String loge = prop.getProperty("log_e");
		if(loge != null && "yes".equals(loge)) {
			KWLOG.EXCEP = true;
			System.out.println("\tlog excep: " + loge);
		} else if(loge != null && "no".equals(loge)) {
			KWLOG.EXCEP = false;
			System.out.println("\tlog excep: " + loge);
		}
	}
	
	public void configFilterSensor(Properties prop) {
		String fs = prop.getProperty("filter_sensors");
		if(fs != null) {
			String[] sensors = fs.split(",");
			if(sensors != null) {
				for(String sensor : sensors) {
					String[] ins = sensor.split("-");
					int group = Integer.parseInt(ins[0]);
					int id = Integer.parseInt(ins[1]);
					SHSensor ss = new SHSensor(group, id, null);
					DeviceFactory.sensorFilter.add(ss);
				}	
			}	
		}
	}
}
