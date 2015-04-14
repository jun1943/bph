package com.tianyi.bph.web.adapter;

import java.nio.charset.CharsetDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.tianyi.bph.constants.Constants;
import com.tianyi.bph.domain.GPSInfor;
import com.tianyi.bph.service.GpsService;

/**
 * 成都市局 GPS
 * 
 * 接收端口：9989
 * 
 * gps数据格式：	
 * 
 * @author Administrator
 *
 */
public class Gps2Handler extends IoHandlerAdapter {

	@Autowired
	private GpsService service;
	
	private final Set<IoSession> sessions = Collections.synchronizedSet(new HashSet<IoSession>());
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date stringToDate(String date) {
		Date result = null;
		try {
			dateFormat.setLenient(true);
			if(!"".equals(date)){
				result = dateFormat.parse(date);
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	/** 处理gps信息 */
	private GPSInfor processGPSData(String msg) {
		String str = msg.substring(1);
		String tmp = str.substring(0,str.length()-1);
		String[] array = tmp.split("\\|");
		String gpsName  	= array[0];
		String gpsId		= array[1];
		String addressTime 	= array[2];
		String speed		= array[3];
		String position		= array[4];
		String gpsX			= array[5];
		String gpsY			= array[6];
		String direction	= array[7];
		String address		= array[8];
		
		GPSInfor gps = new GPSInfor();
		gps.setName(gpsName);
		gps.setGpsId(gpsId);
		gps.setAddressTime(stringToDate(addressTime));
		gps.setSpeed(Double.parseDouble(speed));
		gps.setPosition(Integer.parseInt(position));
		gps.setGpsX(Double.parseDouble(gpsX));
		gps.setGpsY(Double.parseDouble(gpsY));
		gps.setDirection(Double.parseDouble(direction));
		gps.setAddress(address);
		
		return gps;
	}

	/** 接收客户端信息  */
	@Override
	public void messageReceived(IoSession session, Object message) {
		try {
			String msg = null;
			if (message instanceof IoBuffer) {
				IoBuffer buffer = (IoBuffer) message;
				buffer.setAutoExpand(true);
				CharsetDecoder de = Constants.CHARSET.newDecoder();
				msg = buffer.getString(de);
			} else {
				msg = String.valueOf(message);
			}
			
			System.out.println("成都市局 9989 推过来的 GPS: " + msg);
			service.processGPSData(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessions.add(session);
		/*try {
			String msg = null;
			if (message instanceof IoBuffer) {
				IoBuffer buffer = (IoBuffer) message;
				buffer.setAutoExpand(true);
				CharsetDecoder de = Constants.CHARSET.newDecoder();
				msg = buffer.getString(de);
			} else {
				msg = String.valueOf(message);
			}
			
			// 处理数据
			if (StringUtils.hasLength(msg)) {
				System.out.println("成都市局 9989 GPS: " + msg);
				GPSInfor gps = processGPSData(msg);
				service.insert(gps);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessions.add(session);*/
	}

	/** 向客户端发送信息 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		if (message instanceof IoBuffer) {
			CharsetDecoder de = Constants.CHARSET.newDecoder();
			IoBuffer buffer = (IoBuffer) message;
			System.out.println("Server message Sent: " + buffer.getString(de));
		} else {
			System.out.println("Server message Sent: " + message);
		}
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("creat session");
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("open 1 session");
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("session close");
		System.out.println(session.getLocalAddress());
		sessions.remove(session);
	}
	
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		System.out.println("Session idle");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		session.close(true);
	}

}
