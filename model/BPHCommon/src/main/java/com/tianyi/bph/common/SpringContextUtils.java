package com.tianyi.bph.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class SpringContextUtils implements BeanFactoryAware{

	private static BeanFactory factory=null;
	
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		SpringContextUtils.factory=factory;
	}
	
	public static BeanFactory getBeanFacotory(){
		if(factory==null)
			throw new RuntimeException("系统还未初始化，请注意检查代码！");
		
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	public static <X> X getBean(String name){
		return (X) getBeanFacotory().getBean(name);
	}

	public static <X> X getBean(Class<X> class1) {
		return getBeanFacotory().getBean(class1);
	}
	
}
