package com.tianyi.bph.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
	private PatternUtils(){}
	public static final PatternUtils instance = new PatternUtils();
	private static final String IP_REGEX = "^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$";
	private static final String PHONE_REGEX = "^(13|14|15|16|18|19)\\d{9}$";
	private static final String PASSWORD_REGEX = "^[a-zA-Z]\\w{5,17}$";
	private static final String NUMBER_LEETER_REGEX = "^[A-Za-z0-9]+$";
	private static final String DEVICE_REGEX = "^[8]\\d\\d[a-zA-Z0-9]{8}+$";
	private static final String TEL_REGEX="^(([0-9]{3,4}-)|[0-9]{3,4}-)?[0-9]{7,8}$";
	public boolean matchesDevNum(String deviceNum){
		return matches(deviceNum,DEVICE_REGEX);
	}
	public boolean matchesPhone(String phone){
		return matches(phone,PHONE_REGEX);
	}
	public boolean  matchesPassword(String password){
		return matches(password,PASSWORD_REGEX);
	}
	public boolean  matchesIP(String ip){
		return matches(ip,IP_REGEX);
	}
	public boolean  matchesNumberLeeter(String value){
		return matches(value,NUMBER_LEETER_REGEX);
	}
	public boolean matchesTel(String tel){
		return matches(tel,TEL_REGEX);
	}
	public boolean matches(String phone,String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
}
