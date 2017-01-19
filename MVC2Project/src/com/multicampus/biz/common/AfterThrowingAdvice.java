package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

//@Service("afterThrowing")
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
//		if(exceptObj instanceof NullPointerException) {
//			System.out.println("Process A...");
//		} else if(exceptObj instanceof IllegalArgumentException) {
//			System.out.println("Process B...");
//		} else if(exceptObj instanceof SQLException) {
//			System.out.println("Process C...");
//		} else {
//			System.out.println("Default Process ...");
//		}
		
		System.out.println("[예외 처리] " + method + 
			"() 메소드 수행 중 발생된 예외 메시지 : " + exceptObj.getMessage());
	}
}
