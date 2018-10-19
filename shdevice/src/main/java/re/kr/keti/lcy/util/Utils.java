package re.kr.keti.lcy.util;

public class Utils {
	public static int makeByteArraytoInt(int data1, int data2) {
		return (data1 & 0x000000ff) << 8 | (data2 & 0x000000ff) << 0;
	}

}
