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
		
		System.out.println("[���� ó��] " + method + 
			"() �޼ҵ� ���� �� �߻��� ���� �޽��� : " + exceptObj.getMessage());
	}
}