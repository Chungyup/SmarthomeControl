package kr.kw.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class KWLOG {
	public static boolean INFO = true;
	public static boolean DEBUG = false;
	public static boolean EXCEP = false;
	public static boolean HISTORY = false;
	
	private static BufferedWriter bw = null;
	public static void openFile() {
		try {
			if(HISTORY) {
				final String fileName = "log_" + KWUtils.getDate().replaceAll("/", "_");
				bw = new BufferedWriter(new FileWriter(fileName, true));
				bw.append("####################################################\r\n");
				bw.append("log history open time: " + KWUtils.getDateTime() + "\r\n");
				bw.append("####################################################\r\n");
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void info(String tag, String message) {
		if(INFO) {
			System.out.println("(I)" + tag + "] " + message);
			try {
				if(HISTORY) {
					bw.append("(I)" + tag + "] " + message + "\r\n");
					bw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void debug(String tag, String message) {
		if(DEBUG) {
			System.out.println("(D)" + tag + "] " + message);
			try {
				if(HISTORY) {
					bw.append("(D)" + tag + "] " + message + "\r\n");
					bw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void excep(String tag, String message) {
		if(EXCEP) {
			System.out.println("(C)" + tag + "] " + message);
			try {
				if(HISTORY) {
					bw.append("(C)" + tag + "] " + message + "\r\n");
					bw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
