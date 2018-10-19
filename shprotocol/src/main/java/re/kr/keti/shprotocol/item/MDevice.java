package re.kr.keti.shprotocol.item;

public class MDevice {
	private String serialNumber;
	private String deviceType;
	private String modelName;
	private String manufacturer;
	private String size;
	private String weight;
	private String controlType;
	private String power;
	private String regTime;

	public MDevice() {
		
	}
	
	public MDevice(String serialNumber, String deviceType, String modelName, String manufacturer, String size,
			String weight, String controlType, String power, String regTime) {
		this.serialNumber = serialNumber;
		this.deviceType = deviceType;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.size = size;
		this.weight = weight;
		this.controlType = controlType;
		this.power = power;
		this.regTime = regTime;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

}
