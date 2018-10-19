package re.kr.keti.lcy.device.utas.packet;

public class UtasPacketTimer {
	public static final int INTERVAL_CTR = 500;		// 0.5 second
	public static final int INTERVAL_TV = 10000;	// 10 second
	
	public static boolean DELAY(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
