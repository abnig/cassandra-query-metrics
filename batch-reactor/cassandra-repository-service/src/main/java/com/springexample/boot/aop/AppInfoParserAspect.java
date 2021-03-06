package com.springexample.boot.aop;

import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
@Component
public class AppInfoParserAspect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1637854321943131397L;

	@Before("execution(* *.update(..))")
	public void afterSelectForOutboundFile(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println("Number of arguments:" + args.length);
		for(Object o : args) {
			System.out.println("Priting arguments:" + o.toString());
		}
	}

}
