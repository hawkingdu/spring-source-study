package edu.hawking.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 杜皓君 created by 2021/4/24
 * LogInterceptor
 **/
public class LogInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("----"+invocation.getMethod().getName()+"方法执行前-------");
		Object ret = invocation.proceed();
		System.out.println("----"+invocation.getMethod().getName()+"方法执行后-------");
		return ret;
	}
}
