package re.kr.keti.shprotocol;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import re.kr.keti.shprotocol.item.BMS;
import re.kr.keti.shprotocol.item.Gateway;
import re.kr.keti.shprotocol.item.Guest;
import re.kr.keti.shprotocol.item.HomeAppliance;
import re.kr.keti.shprotocol.item.MDevice;
import re.kr.keti.shprotocol.item.Manager;
import re.kr.keti.shprotocol.item.Mashup;
import re.kr.keti.shprotocol.item.MirrorTV;
import re.kr.keti.shprotocol.item.QR;
import re.kr.keti.shprotocol.item.Schedule;
import re.kr.keti.shprotocol.item.Sensor;
import re.kr.keti.shprotocol.item.Service;
import re.kr.keti.shprotocol.item.Smartband;
import re.kr.keti.shprotocol.item.Smartphone;
import re.kr.keti.shprotocol.item.User;

public class KMessage extends KHeader {
	private Object data;

	/**
	 * 
	 * @param to
	 * @param from
	 * */
	public KMessage(String to, String from, String id, int mt, int cmd, int ct, int ctt, Object data) {
		super.to = to;
		super.from = from;
		super.id = id;
		super.mt = mt;
		super.cmd = cmd;
		super.ct = ct;
		super.ctt = ctt;
		this.data = data;
	}

	public Object getData() {
		return data;
	}
	
	public BMS getBMS() {
		return gson.fromJson(gson.toJson(data), BMS.class);
	}
	
	public List<BMS> getBMSList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), BMS[].class));
	}

	public Gateway getGateway() {
		return gson.fromJson(gson.toJson(data), Gateway.class);
	}

	public List<Gateway> getGatewayList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Gateway[].class));
	}
	
	public Guest getGuest() {
		return gson.fromJson(gson.toJson(data), Guest.class);
	}
	
	public List<Guest> getGuestList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Guest[].class));
	}

	public HomeAppliance getHA() {
		return gson.fromJson(gson.toJson(data), HomeAppliance.class);
	}
	
	public List<HomeAppliance> getHAList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), HomeAppliance[].class));
	}

	public Manager getManager() {
		return gson.fromJson(gson.toJson(data), Manager.class);
	}
	
	public List<Manager> getManagerList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Manager[].class));
	}

	public QR getQR() {
		return gson.fromJson(gson.toJson(data), QR.class);
	}

	public List<QR> getQRList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), QR[].class));
	}
	
	public Schedule getSchedule() {
		return gson.fromJson(gson.toJson(data), Schedule.class);
	}

	public List<Schedule> getScheduleList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Schedule[].class));
	}
	
	public Sensor getSensor() {
		return gson.fromJson(gson.toJson(data), Sensor.class);
	}
	
	public List<Sensor> getSensorList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Sensor[].class));
	}

	public Service getService() {
		return gson.fromJson(gson.toJson(data), Service.class);
	}
	
	public List<Service> getServiceList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Service[].class));
	}
	
	public Smartband getSmartband() {
		return gson.fromJson(gson.toJson(data), Smartband.class);
	}
	
	public List<Smartband> getSmartbandList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Smartband[].class));
	}
	
	public Smartphone getSmartphone() {
		return gson.fromJson(gson.toJson(data), Smartphone.class);
	}
	
	public List<Smartphone> getSmartphoneList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Smartphone[].class));
	}
		
	public User getUser() {
		return gson.fromJson(gson.toJson(data), User.class);
	}
	
	public List<User> getUserList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), User[].class));
	}
	
	public MDevice getMDevice() {
		return gson.fromJson(gson.toJson(data), MDevice.class);
	}
	
	public List<MDevice> getMDeviceList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), MDevice[].class));
	}

	
	public MirrorTV getMirrorTV() {
		return gson.fromJson(gson.toJson(data), MirrorTV.class);
	}

	public List<MirrorTV> getMirrorTVList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), MirrorTV[].class));
	}
	
	public int getBrtn() {
		return gson.fromJson(gson.toJson(data), Integer.class);
	}
	
	public Mashup getMashup() {
		return gson.fromJson(gson.toJson(data), Mashup.class);
	}
	
	public List<Mashup> getMashupList() {
		return Arrays.asList(gson.fromJson(gson.toJson(data), Mashup[].class));
	}
	
	private static Gson gson = new GsonBuilder().create();
	public static KMessage getMessage(String message) {
		KMessage oMessage = null;

		try {
			oMessage = gson.fromJson(message, KMessage.class);
		} catch (JsonSyntaxException e) {
			System.out.println(e.getMessage());
		} catch (JsonParseException e) {
			System.out.println(e.getMessage());
		}

		return oMessage;
	}

	public String getJSONMessage() {
		return gson.toJson(this);
	}
}
