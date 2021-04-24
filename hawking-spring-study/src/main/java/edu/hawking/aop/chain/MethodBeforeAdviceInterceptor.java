package edu.hawking.aop.chain;

import edu.hawking.aop.MyLogAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 杜皓君 created by 2021/4/24
 * MethodBeforeAdviceInterceptor
 **/
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {
	MethodBeforeAdvice methodBeforeAdvice;

	public MethodBeforeAdviceInterceptor(MethodBeforeAdvice methodBeforeAdvice) {
		this.methodBeforeAdvice = methodBeforeAdvice;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		methodBeforeAdvice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
		return invocation.proceed();
	}
}
