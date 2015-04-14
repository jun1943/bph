package com.tianyi.bph.service;

import java.net.InetSocketAddress;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tianyi.bph.constants.Constants;


/**
 * 客户端
 * 
 * @author Administrator
 *
 */
public class GpsClient extends IoHandlerAdapter {

	private final static Logger LOGGER = LoggerFactory.getLogger(GpsClient.class);
	
	private IoSession session;
	private IoConnector connector;
	public String IP = "25.30.9.108";
	public int PORT = 7770;

	/**
	 * Default constructor.
	 */
	public GpsClient() {
		connector = new NioDatagramConnector();
		connector.setHandler(this);
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(IP, PORT));
		connFuture.awaitUninterruptibly();
		// 给conn添加一个监听器
		connFuture.addListener(new IoFutureListener<ConnectFuture>() {
			public void operationComplete(ConnectFuture future) {
				if (future.isConnected()) {
					session = future.getSession();
				} else {
					try {
						LOGGER.error(" 连接错误。 ");
						throw new Exception(" 连接错误。 ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void sendData(Object message) throws InterruptedException {

		IoBuffer buffer = IoBuffer.allocate(message.toString().length() + 100);
		CharsetEncoder ce = Constants.CHARSET.newEncoder();
		CharSequence charSequence = message.toString();
		try {
			buffer.putString(charSequence, ce);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
		buffer.flip();
		session.write(buffer); // 写入

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)	throws Exception {
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		CharsetDecoder cd = Constants.CHARSET.newDecoder();
		IoBuffer buffer = (IoBuffer) message;
		System.out.println("客户端收到来自服务器的消息String:" + (buffer.getString(cd)));
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		CharsetDecoder cd = Constants.CHARSET.newDecoder();
		IoBuffer buffer = (IoBuffer) message;
		System.out.println("客户端向服务器发送信息：" + buffer.getString(cd));
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("客户端关闭了当前会话");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("客户端成功创建session");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		System.out.println("session闲置");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("客户端成功开启一个session id:" + session.getId());
	}

	public static void main(String[] args) {
		
		GpsClient u = new GpsClient();
		try {
			u.sendData("@川A3642警|13900001472|2011-06-14 12:52:01|10|1|104.06872|30.674728|270|四川省 成都市 文武路 成都兴业律师楼#");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
