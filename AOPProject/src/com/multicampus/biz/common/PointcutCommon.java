package com.multicampus.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.user.*Impl.*(..))")
	public void userPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
}
