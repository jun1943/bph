package com.tianyi.bph.web.rabbitmq;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class UtilTools {

	/**
	 * 反射得到属性值
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public static void getParamValues(Object obj) {
		try {
			Method[] methods = obj.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().indexOf("get") >= 0) {
					System.out.println(method.getName() + "-->"
							+ method.invoke(obj, new Object[0]) + "<--");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 设置gps_alarm中info_id的值
	public static long getInfo_id(String info_id) {
		long infoid = Long.parseLong(info_id);
		if (4294967295l >= ++infoid) {
			return infoid;
		} else {
			return 0;
		}
	}

	public static String getDate() {
		Date date = new Date();
		return formatDate(date);
	}

	public static Date parseDate(String str) {
		Date date = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String formatDate(Date date) {
		String str = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			str = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static int compareDate(Date date1, Date date2) {
		int result;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		// cal1.set(Calendar.SECOND, 0);
		// cal1.set(Calendar.MILLISECOND, 0);
		// cal2.set(Calendar.SECOND, 0);
		// cal2.set(Calendar.MILLISECOND, 0);
		cal2.setTime(date2);
		result = cal1.compareTo(cal2);
		return result;
	}

	/**
	 * @param strDate1
	 * @param strDate2
	 * @return-1<0;0=;1>
	 */
	public static int compareDate(String strDate1, String strDate2) {
		int result;
		Date date1 = parseDate(strDate1);
		Date date2 = parseDate(strDate2);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		result = cal1.compareTo(cal2);
		return result;
	}

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long diffDate(Date date1, Date date2) {
		long result;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		long milliseconds1 = cal1.getTimeInMillis();
		long milliseconds2 = cal2.getTimeInMillis();
		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		// long diffMinutes = diff / (60 * 1000);
		// long diffHours = diff / (60 * 60 * 1000);
		// long diffDays = diff / (24L * 60 * 60 * 1000);
		result = Math.abs(diffSeconds);
		return result;
	}

	public static long diffDate(String strDate1, String strDate2) {
		Date date1 = parseDate(strDate1);
		Date date2 = parseDate(strDate2);
		long result;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		long milliseconds1 = cal1.getTimeInMillis();
		long milliseconds2 = cal2.getTimeInMillis();
		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		// long diffMinutes = diff / (60 * 1000);
		// long diffHours = diff / (60 * 60 * 1000);
		// long diffDays = diff / (24L * 60 * 60 * 1000);
		result = Math.abs(diffSeconds);
		return result;
	}

	public static long getUTC(String strDate) {
		// 1、取得本地时间：
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(parseDate(strDate));
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(0));
		// cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		// 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
		return cal.getTimeInMillis() / 10000;
	}

	/**
	 * @param inputString
	 * @return
	 */
	public static byte[] stringToByte(String inputString) {
		int strLen = inputString.length();
		char[] charResult = new char[strLen];
		byte[] byteResult = new byte[strLen];
		for (int i = 0; i < strLen; i++) {
			charResult[i] = inputString.charAt(i);
			byteResult[i] = (byte) charResult[i];
		}
		return byteResult;
	}

	/**
	 * 将int型转为byte[]，高位byte存储高位
	 * 
	 * @param int inputNum
	 * @return byte[]
	 */
	public static byte[] intToByte(int inputNum) {

		int count = 0;
		if (inputNum < (Math.pow(2, 8)))
			count = 1;
		else if (inputNum < (Math.pow(2, 16)))
			count = 2;
		else if (inputNum < (Math.pow(2, 24)))
			count = 3;
		else if (inputNum < (Math.pow(2, 32)))
			count = 4;
		byte[] byteResult = new byte[count];
		for (int i = 0; i < count; i++) {
			byteResult[i] = (byte) ((inputNum >> (8 * i)) & 0xff);
		}
		return byteResult;

	}

	/**
	 * 将byte[]转为int，高位byte存储的是高位，从高位开始解析
	 * 
	 * @param inputByte
	 * @return int
	 */
	public static int byteToInt(byte[] inputByte) {
		int count = inputByte.length;

		int result = 0;
		for (int i = count - 1; i >= 0; i--) {
			if (inputByte[i] < 0) {
				int temp = 0;
				temp = 256 + inputByte[i];
				result = (result << 8) + temp;
			} else {
				result = (result << 8) + inputByte[i];
			}
		}
		return result;
	}

	/**
	 * 将byte[]转为string
	 * 
	 * @param inputByte
	 * @return String
	 */
	public static String byteToString(byte[] inputByte) {
		int len = inputByte.length;
		String result = "";
		for (int i = 0; i < len; i++) {
			result = result + (char) inputByte[i];
		}
		return result;
	}

	public static String getFormatDouble(Double num) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.setMaximumFractionDigits(6);
		String str = df.format(num);
		return str;
	}

	public static void main(String[] args) {
		System.out.println(getFomatDate());
		System.out.println(UtilTools.compareDate("2013-11-14 11:48:02",
				"2013-11-14 11:48:32"));
		System.out.println(UtilTools.compareDate("2013-11-14 11:48:02",
				"2013-11-14 11:48:02"));
		System.out.println(UtilTools.compareDate("2013-11-14 11:48:03",
				"2013-11-14 11:48:02"));
		UtilTools.getFormatDouble(1.111);

		char[] ch = "101".toCharArray();
		System.out.println(ch[1] == 0);
		System.out.println(ch[1] == '0');

		// 1、取得本地时间：
		java.util.Calendar cal = java.util.Calendar.getInstance();
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		// 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
		System.out.println("UTC:" + cal.getTimeInMillis());
		System.out.println("UTC:" + new Date(cal.getTimeInMillis()));

		System.out.println(UtilTools.getUTC("2013-12-04 00:00:00"));
		// Object[] ab = new Object[2];
		// ab[0] = "nihao";
		// ab[1] = 2;
		// List aa = new ArrayList();
		// aa.add("999");
		// System.out.println(UtilTools.getString("dsfdf", ab,aa));
	}

	public static String getFomatDate() {
		return new SimpleDateFormat("yyyyMMdd/HHmmss").format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 检查当前时间是否在有效时间内
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isValidTime(Date start, Date end) {
		boolean bool = false;
		if (start != null && end != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(start);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(end);
			int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if (cal1.get(Calendar.HOUR_OF_DAY) < now
					&& now < cal2.get(Calendar.HOUR_OF_DAY)) {
				bool = true;
			}
		}
		return bool;
	}
	

}
