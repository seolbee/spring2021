package com.yydh.myapp.board;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	//<aop:pointcut expression="execution(* com.yydh.myapp..*Impl.*(..))" id="allPointcut" />
	@Pointcut("execution(* com.yydh.myapp..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.yydh.myapp..*Impl.insertBoard(..))")
	public void insertPointCut() {};
	
//	<aop:aspect ref="log">
//		<aop:before method="printLog" pointcut-ref="allPointcut"/>
//		<aop:after method="printLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//	@After("allPointCut()")
//	public void printLog() {
//		System.out.println("수행중");
//	}
	
	@Around("allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[로깅 전] 비즈니스 로직 수행 전 동작입니다.");
		Object obj = pjp.proceed();
		System.out.println("[로깅 후] 비즈니스 로직 수행 후 동작입니다.");
		return obj;
	}
	
	@Around("insertPointCut()")
	public Object aroundInsertLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("인서트 시작 전");
		Object obj = pjp.proceed();
		System.out.println("인서트 시작 후");
		return obj;
	}
}
