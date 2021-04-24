package edu.hawking.aop.chain;

import edu.hawking.aop.LogInterceptor;
import edu.hawking.aop.MyLogAdvice;
import edu.hawking.aop.TulingCalculate;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 杜皓君 created by 2021/4/24
 * InvokeChainDemo
 **/
public class InvokeChainDemo {

	public static void main(String[] args) throws Throwable {
		List<MethodInterceptor> list = new ArrayList<>();
		list.add(new MethodBeforeAdviceInterceptor(new MyLogAdvice()));
		list.add(new LogInterceptor());

		MyMethodInvocation methodInvocation = new MyMethodInvocation(list);
		methodInvocation.proceed();
	}

	public static class MyMethodInvocation implements MethodInvocation {
		List<MethodInterceptor> list;
		final TulingCalculate target;
		int i = 0;

		public MyMethodInvocation(List<MethodInterceptor> list) {
			this.list = list;
			this.target = new TulingCalculate();
		}

		@Override
		public Object[] getArguments() {
			return new Object[0];
		}

		@Override
		public Object proceed() throws Throwable {
			if (i == list.size()) {
				return target.add(2, 3);
			}
			MethodInterceptor mi = list.get(i);
			i++;
			return mi.invoke(this);
		}

		@Override
		public Object getThis() {
			return null;
		}

		@Override
		public AccessibleObject getStaticPart() {
			return null;
		}

		@Override
		public Method getMethod() {
			try {
				return target.getClass().getMethod("add", int.class, int.class);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
