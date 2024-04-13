package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {}
	
	
//	@Before("mypt()")
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}
	
//	@AfterReturning(value = "mypt()", returning = "line")
	public void afterReturning(int line) {
		System.out.println("Git에 Push 한다. : "+line+"개의 줄을....");
	}
	
//	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if(th instanceof OuchException)
			((OuchException) th).handleException();
	}
	
//	@After("mypt()")
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}
	
	/////////////////////////////
	//aroud
	@Around("mypt()")
	public int around(ProceedingJoinPoint pjt) {
		int line = 0;
		
		this.before();
		try {
			line = (int)pjt.proceed();
			this.afterReturning(line);
		} catch (Throwable e) {
			this.afterThrowing(e);
		}finally{
			this.after();
		}
		return line;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
