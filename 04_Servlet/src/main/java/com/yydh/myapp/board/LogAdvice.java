package com.yydh.myapp.board;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {

	@Pointcut("execution(* com.yydh.myapp..*Impl.*(..))")
	public void allPointcut() {}
	
//	@Before("allPointcut()")
//	public void printLog() {
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작 : 로그 생성!!!");
//	}
//	
//	@After("allPointcut()")
//	public void printLog2() {
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작 : 로그 생성!!!");
//	}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		
		System.out.println("[로깅 전] 비즈니스 로직 수행 전 동작입니다.");
		
		Object obj = pjp.proceed();
		
		System.out.println("[로깅 후] 비즈니스 로직 수행 후 동작입니다.");

		
		
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
