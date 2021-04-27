package edu.hawking.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 杜皓君 created by 2021/4/24
 * MyLogAdvice
 **/
public class MyLogAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行目标方法【"+method.getName()+"】前操作，参数：" + Arrays.asList(args));
	}
}
