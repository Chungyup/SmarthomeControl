package re.kr.keti.lcy.device;

public interface SensorState {
	public void updateSensorState(Byte[] payload);
	
	/**
	 * ???���? 값�? '='�? 구분?���?, ?��?��?��?�� ','�? 구분?��?��.
	 * 
	 * example) [type]=[value],[type]=[value]
	 * 
	 * */
	public String getStateList();
	
	public String getManuf();
}
