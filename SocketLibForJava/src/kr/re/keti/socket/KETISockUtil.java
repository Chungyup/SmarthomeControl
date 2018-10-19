package kr.re.keti.socket;

public class KETISockUtil {
	public static String byteArrayToHex(byte[] ba, int length) {
	    if (ba == null && length <= 0) {
	        return null;
	    }
	 
	    StringBuffer sb = new StringBuffer(length * 2);
	    String hexNumber;
	    for (int x = 0; x < length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
	 
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    return sb.toString();
	}
}
