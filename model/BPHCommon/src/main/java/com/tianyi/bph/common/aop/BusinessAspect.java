package com.tianyi.bph.common.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.annotation.MQDataInterceptor;
import com.tianyi.bph.common.mq.BaseData;

/**
 * 
 * @TODO
 * @author chen
 * @date 2015年3月18日
 */
@Aspect
@Component
public class BusinessAspect {

	static final Logger log = LoggerFactory.getLogger(BusinessAspect.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 当方法执行完成后 将返回的数据写入mq 及时通知客户端
	 * 
	 * @param jp
	 * @param object
	 */
	@AfterReturning(value = "@annotation(com.tianyi.bph.common.annotation.MQDataInterceptor)", returning = "object")
	public void afterProcess(JoinPoint jp, Object object) {
		Signature signature = jp.getSignature();
		if (signature instanceof MethodSignature) {
			MethodSignature methodSignature = (MethodSignature) signature;
			Method method = methodSignature.getMethod();
			MQDataInterceptor dataInterceptor = method
					.getAnnotation(MQDataInterceptor.class);
			if (dataInterceptor != null && object != null) {
				try {
					BaseData data = new BaseData();
					String type = dataInterceptor.type();
					int operate = dataInterceptor.operate();
					data.setData(object);
					data.setType(type);
					data.setOperTypeCode(operate);
					if (rabbitTemplate != null&&rabbitTemplate.isConfirmListener()) {
						rabbitTemplate.convertAndSend(Constants.MQ_ROUTING_KEY
								+ "." + type, JsonUtils.toJson(data));
						log.info("发送信息到mq队列完成：" + JsonUtils.toJson(data));
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error("发送队列失败，message：" + e.getMessage());
				}
			}
		}

	}

}
