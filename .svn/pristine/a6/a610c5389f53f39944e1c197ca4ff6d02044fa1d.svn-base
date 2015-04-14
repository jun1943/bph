package com.tianyi.bph.web.adapter;

import java.nio.charset.CharsetDecoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.constants.Constants;
import com.tianyi.bph.service.GpsService;

/**
 * 接收成都市局（接收端口：7770）推送过来的GPS信息 接口
 * 
 * gps数据格式：	@车牌号|终端编号|时间|速度|定位|经度|纬度|方向|位置#
 * 				@川A3642警|13900001472|2011-06-14 12:52:01|10|1|104.06872|30.674728|270|四川省 成都市 文武路 成都兴业律师楼#
 * C:\bph\cdsj\gps_push_test\UDPTestTool
 * @author Administrator
 *
 */
public class Gps1Handler extends IoHandlerAdapter {
	
	@Autowired
	private GpsService service;
	
	private final Set<IoSession> sessions = Collections.synchronizedSet(new HashSet<IoSession>());
	
	/** 服务端：接收GPS厂家推送过来的gps信息  */
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
			
			System.out.println("成都市局7770推过来的 GPS: " + msg);
			service.processGPSData(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessions.add(session);
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
