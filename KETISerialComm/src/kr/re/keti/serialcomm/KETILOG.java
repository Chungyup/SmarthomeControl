package kr.re.keti.serialcomm;

public class KETILOG {
	public static final boolean D = false;
	public static final boolean C = false;
	
	public static void debug(String tag, String message) {
		if(D)
			System.out.println("(I)" + tag + "] " + message);
	}
	
	public static void exception(String tag, String message) {
		if(C)
			System.out.println("(C)" + tag + "] " + message);
	}	
}
