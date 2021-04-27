package edu.hawking.postprocessor;

import edu.hawking.circularreference.JdkDynamicProxy;
import edu.hawking.service.Aservice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

/**
 * 杜皓君 created by 2021/4/23
 * JdkProxyBeanPostProcessor
 **/
public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {

		// 假设A命中动态代理
		if (bean instanceof Aservice) {
			JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(bean);
			return jdkDynamicProxy.getProxy();
		}
		return bean;
	}
}
