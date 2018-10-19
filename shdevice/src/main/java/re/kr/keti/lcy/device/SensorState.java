package re.kr.keti.lcy.device;

public interface SensorState {
	public void updateSensorState(Byte[] payload);
	
	/**
	 * ???κ³? κ°μ? '='λ‘? κ΅¬λΆ?κ³?, ?°?΄?°? ','λ‘? κ΅¬λΆ??€.
	 * 
	 * example) [type]=[value],[type]=[value]
	 * 
	 * */
	public String getStateList();
	
	public String getManuf();
}
