package re.kr.keti.lcy.device.maxfor.item;

import re.kr.keti.lcy.device.Manufacturer;
import re.kr.keti.lcy.device.SensorState;
import re.kr.keti.lcy.util.Utils;


/**
 * tag ID = device ID
 *
 * */
public class MaxforLocationTag implements SensorState {
	// common
//	public static final int LOCATION_OUTSIDE = 65535;
	public static final int LOCATION_OUTSIDE = 10004;
		
	// home
	public static final int LOCATION_TV_ZONE = 10013;
	public static final int LOCATION_LIVINGROOM = 10017;
	public static final int LOCATION_BEDROOM1 = 10015;
	public static final int LOCATION_BEDROOM2 = 10018;
	public static final int LOCATION_KITCHEN = 10014;
	public static final int LOCATION_ENTRY = 10016;
	public static final int LOCATION_BATHROOM = 10019;
	
	// building
	public static final int LOCATION_1F_ENTRANCE = 10011;
	public static final int LOCATION_1F = 10020;
	public static final int LOCATION_5F_ENTRANCE = 10007;
	public static final int LOCATION_5F = 10021;
	public static final int LOCATION_6F_ENTRANCE = 10004;
	public static final int LOCATION_6F = 10005;
	public static final int LOCATION_7F_ENTRANCE = 10001;
	public static final int LOCATION_7F = 10022;
	
	private int tagId;
	private int readerId;

	public MaxforLocationTag(int tagId){
		this.tagId = tagId;
	}
	
	public MaxforLocationTag(int tagId, Byte[] state) {
		this.tagId = tagId;
		updateSensorState(state);
	}
	
	public void updateSensorState(Byte[] state) {
		readerId = Utils.makeByteArraytoInt(state[0], state[1]);
	}
	
	public String getStateList() {
		return "tagId=" + tagId + ",readerId=" + readerId;
	}
	
	public int getTagId() {
		return tagId;
	}
	
	public int getReaderId() {
		return readerId;
	}
	
	public String getManuf() {
		return Manufacturer.MAXFOR;
	}

	@Override
	public String toString() {
		return "readerId=" + readerId;
	}
}
