package com.tianyi.bph.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title: 系统时间公共类
 * </p>
 * <li>提供取得系统时间的所有共用方法</li> <br>
 * 
 * @author stephen
 * @version YHBBS-2.0
 */
public class DateUtils {
	private static final Logger log=LoggerFactory.getLogger(DateUtils.class);
	public static final SimpleDateFormat YYYYMMDDHHMMSS=new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat YYYYMMDD=new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat YYYY_MM=new SimpleDateFormat("yyyy-MM");
	public static final SimpleDateFormat YYYY_MM_DD=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 取得昨天此时的时间
	 * @return 昨天日期（Date）
	 */
	public static Date getYesterdayDate() {
		return new Date(System.currentTimeMillis()- 0x5265c00L);
	}
	
	public static Date parse(String date,SimpleDateFormat format) {
		if(StringUtils.isEmpty(date)){
			return null;
		}
		try {
			return format.parse(date);
		} catch (ParseException e) {
			log.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * 取得去过i天的时间
	 * @param i 过去时间天数
	 * @return 昨天日期（Date）
	 */
	public static Date getPastdayDate(int i) {
		return new Date(System.currentTimeMillis()- 0x5265c00L * i);
	}
	public static Date getPastdayDate(Date date,int i) {
		return new Date(date.getTime()- 0x5265c00L * i);
	}
	


	/**
	 * 取得某日期时间的特定表示格式的字符串
	 * @param format  时间格式
	 * @param date  某日期（Date）
	 * @return 某日期的字符串
	 */
	public static synchronized String format(Date date,String format) {
		SimpleDateFormat ft=new SimpleDateFormat(format);
		return ft.format(date);
	}
	
	/**
	 * 取得某日期时间的特定表示格式的字符串
	 * @param format  时间格式
	 * @param date  某日期（Date）
	 * @return 某日期的字符串
	 */
	public static synchronized String format(Date date,DateFormat format) {
		return format.format(date);
	}

	/**
	 * 以分钟的形式表示两个长整型数表示的时间间隔
	 * @param from 开始的长整型数据
	 * @param to 结束的长整型数据
	 * @return 相隔的分钟数
	 */
	public static int getOffMinutes_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / 60000L));
	}
	/**
	 * 
	 * @param from
	 * @param to
	 * @return 相隔的秒钟
	 */
	public static int getOffSeconds_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / 1000L));
	}
	
	/**
	 * 以天的形式表示两个长整型数表示的时间间隔
	 * @param from 开始的长整型数据
	 * @param to 结束的长整型数据
	 * @return 相隔的天数
	 */
	public static int getOffDays_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / (60000L*60*24)));
	}


	 
}