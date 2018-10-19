package re.kr.keti.lcy.device;

public interface SensorState {
	public void updateSensorState(Byte[] payload);
	
	/**
	 * ???…ê³? ê°’ì? '='ë¡? êµ¬ë¶„?•˜ê³?, ?°?´?„°?Š” ','ë¡? êµ¬ë¶„?•œ?‹¤.
	 * 
	 * example) [type]=[value],[type]=[value]
	 * 
	 * */
	public String getStateList();
	
	public String getManuf();
}
