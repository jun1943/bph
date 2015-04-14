package com.tianyi.bph.web.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.domain.GPSInfor;

/**
 * 将实时的 gps 信息推送至MQ服务
 * 
 * @author Administrator
 *
 */
public class MessageProducer {  
	
	@Autowired
	private RabbitTemplate rabbitTemplate;  
	
	public void sendMessage(GPSInfor gps) {  
		
//		rabbitTemplate.convertAndSend(routingKey, object);
		
//		String message = "Hello World wubin " + "#" + i;  
//		//Exchange的名称为"hello.topic"，routingkey的名称为"hello.world.q123ueue"  
//		rabbitTemplate.convertAndSend("hello.topic", "hello.world.q123ueue", message);  
//		System.out.println("发送第" + i + "个消息成功！内容为：" + message);  
//		
//		String messages = "Hello World direct " + "#" + i;  
//		rabbitTemplate.convertAndSend("hello.direct", "hello.world.queue", messages);  
//		System.out.println("发送第" + i + "个消息成功！内容为：" + messages);  
	}  
	  
}