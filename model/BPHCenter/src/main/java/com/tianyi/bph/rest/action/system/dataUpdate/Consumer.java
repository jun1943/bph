package com.tianyi.bph.rest.action.system.dataUpdate;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
 * 
 * 描述: 消费者，从 MQ 获取数据
 * 
 */
public class Consumer implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			String strs = UtilTools.byteToString(message.getBody());
			
			
			System.out.println("++++++++++++++++" + message.getBody());
			System.out.println("++++++++++++++++" + strs);
			
			
		} catch (Exception e) {
			System.out.println("队列消息处理异常:" + e.getMessage());
		} finally {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}
	
}