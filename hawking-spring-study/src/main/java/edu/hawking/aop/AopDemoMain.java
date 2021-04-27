package edu.hawking.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 杜皓君 created by 2021/4/26
 * AopDemoMain
 **/
public class AopDemoMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		Calculate tulingCalculate = context.getBean("tulingCalculate", Calculate.class);
		tulingCalculate.add(1,2);
	}
}
