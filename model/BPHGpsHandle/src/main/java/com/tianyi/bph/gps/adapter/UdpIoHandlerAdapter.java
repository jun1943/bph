package com.tianyi.bph.gps.adapter;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

//import com.megaeyes.support.ResultHandler;

/**
 * 
 * @TODO
 * @author chen
 * @date 2015年1月26日
 */
public class UdpIoHandlerAdapter extends IoHandlerAdapter {
	private Logger logger = Logger.getLogger(UdpIoHandlerAdapter.class);
	private final Set<IoSession> sessions = Collections
			.synchronizedSet(new HashSet<IoSession>());

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("=============sessionID：" + session.getId());
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {

		try {
			String msg = "";
			msg = (String) message;
			System.out.println("Server Received: " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessions.add(session);

		// if (message instanceof ResultHandler) {
		// ResultHandler handler = (ResultHandler) message;
		// seervice.asyncSend(handler);
		// } else {
		// logger.info("=============消息无效：" + message.getClass());
		// }
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		session.close(true);
	}

	/**
	 * 当信息已经传送给客户端后触发此方法.
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("messageSent:" + session.getId());
	}

	/**
	 * 当连接被关闭时触发，例如客户端程序意外退出等等
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info(" sessionClosed sessionID:" + session.getId());
	}

	/**
	 * 当连接空闲时触发此方法.
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		logger.info("client sessionIdle sessionID:" + session.getId());
	}

	/**
	 * 当连接后打开时触发此方法，一般此方法与 sessionCreated 会被同时触发
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("client sessionOpened sessionID:" + session.getId());
	}
}