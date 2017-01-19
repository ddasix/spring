package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("log")
@Aspect	//Aspect = PointCut + Advice
public class LogAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void printLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("[사전 처리]" + method + "() method agrs:"+ args[0].toString());
	}
}
