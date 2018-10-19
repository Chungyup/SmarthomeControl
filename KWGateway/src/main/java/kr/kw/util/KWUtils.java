package kr.kw.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import kr.kw.service.contextawareness.arff.ARFF;

public class KWUtils {
	public static int makeByteArraytoInt(int data1, int data2) {
		return (data1 & 0x000000ff) << 8 | (data2 & 0x000000ff) << 0;
	}

	public static String bytesToHexString(byte[] bytes, int length) {
		if(bytes == null || length <= 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			byte b = bytes[i];
			sb.append(String.format("%02x ", b & 0xff));
		}
		return sb.toString();
	}
	
	public static int getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static String getTime() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static List<ARFF> list(Iterator<ARFF> iterator) {
		List<ARFF> list = new ArrayList<ARFF>();
		for(@SuppressWarnings("unused")
		Iterator<ARFF> i = iterator; iterator.hasNext(); ) {
			ARFF e = iterator.next();
			list.add(e);
		}
		
		return list;
	}
}
