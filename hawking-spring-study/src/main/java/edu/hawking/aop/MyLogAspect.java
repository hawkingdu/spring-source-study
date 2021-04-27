package edu.hawking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 杜皓君 created by 2021/4/26
 * MyLogAspect 切面类
 **/
@Aspect
@Order
@Component
public class MyLogAspect {

	/**
	 * 注解切点，使用aspectj 切点表达式
	 */
	@Pointcut("execution(* edu.hawking.aop.TulingCalculate.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("doBefore 连接点："+joinPoint.getSignature().getDeclaringTypeName()+"#"+joinPoint.getSignature().getName());
		System.out.println("运行 "+joinPoint.getSignature().getName()+" 前");
	}

	@AfterReturning(value = "pointCut()", returning = "returning")
	public void doAfterReturn(JoinPoint joinPoint, Object returning) {
		System.out.println("doAfterReturn 连接点："+joinPoint.getSignature().getDeclaringTypeName()+"#"+joinPoint.getSignature().getName());
		System.out.println("运行 "+joinPoint.getSignature().getName()+" 执行结果：" + returning);
	}

	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("doAfter 连接点："+joinPoint.getSignature().getDeclaringTypeName()+"#"+joinPoint.getSignature().getName());
		System.out.println("运行 "+joinPoint.getSignature().getName()+" 后");
	}
}
