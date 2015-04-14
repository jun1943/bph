package com.megaeyes.drs.business;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 消息处理接口类
 * 
 * @author Administrator
 * 
 */
@Service
public class DataHandlerServiceImpl implements DataHandlerService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private final static String routingKey = "";

	/**
	 * 
	 */
	@Async
	public void asyncSendMessage(final String message) {

		// 业务逻辑处理

		rabbitTemplate.convertAndSend(routingKey, message);
	}

}
