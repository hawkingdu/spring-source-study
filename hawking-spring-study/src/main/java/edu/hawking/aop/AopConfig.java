package edu.hawking.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 杜皓君 created by 2021/4/24
 * AopConfig
 **/
@Configuration
@ComponentScan("edu.hawking.aop")
@EnableAspectJAutoProxy
public class AopConfig {

//	@Bean
//	ProxyFactoryBean calculateProxy() {
//		ProxyFactoryBean proxyFactoryBean=new ProxyFactoryBean();
//		proxyFactoryBean.setInterceptorNames("myLogAdvice", "logInterceptor");
//		proxyFactoryBean.setTarget(tulingCalculate());
//		return proxyFactoryBean;
//	}

//	 //被代理对象
//	@Bean
//	public Calculate tulingCalculate() {
//		return new TulingCalculate();
//	}
//
//	// Advice 方式
//	@Bean
//	public MyLogAdvice myLogAdvice(){
//		return new MyLogAdvice();
//	}
//
//	// Interceptor方式 ， 可以理解为环绕通知
//	@Bean
//	public LogInterceptor logInterceptor() {
//		return new LogInterceptor();
//	}
}
