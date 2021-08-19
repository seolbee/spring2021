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
//		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ���� : �α� ����!!!");
//	}
//	
//	@After("allPointcut()")
//	public void printLog2() {
//		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ���� : �α� ����!!!");
//	}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		
		System.out.println("[�α� ��] ����Ͻ� ���� ���� �� �����Դϴ�.");
		
		Object obj = pjp.proceed();
		
		System.out.println("[�α� ��] ����Ͻ� ���� ���� �� �����Դϴ�.");

		
		
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
