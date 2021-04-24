package edu.hawking.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 杜皓君 created by 2021/4/23
 * MyBeanPostProcessor
 **/
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("实例化前 beanName" + beanName);
		System.out.println("实例化前 beanClass" + beanClass.getName());
		return null;
	}


}
