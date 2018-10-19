package kr.re.keti.socket;

public class KETISocketLog {
	public static boolean I = false;
	public static boolean D = false;
	public static boolean E = false;
	public static boolean C = false;

	public static void info(String tag, String message) {
		if (I) {
			System.out.println("(I) " + tag + "] " + message);
		}
	}

	public static void debug(String tag, String message) {
		if (D) {
			System.out.println("(D) " + tag + "] " + message);
		}
	}

	public static void error(String tag, String message) {
		if (E) {
			System.out.println("(E) " + tag + "] " + message);
		}
	}

	public static void exception(String tag, String message) {
		if (C) {
			System.out.println("(C) " + tag + "] " + message);
		}
	}
}
