package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {}
	
	@Before("mypt()")
	public void before() {
		System.out.println("컴퓨터 부팅");
		
	}
	
	@AfterReturning(value= "mypt()", returning = "line")
	public void afterReturning(int line) {
		System.out.println("git push : "+line+"개의 줄을...");
	}

	@AfterThrowing(value = "mypt()", throwing= "th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴");
		if(th instanceof OuchException)
			((OuchException) th).handleException();
	}
	
	@After("mypt()")
	public void after() {
		System.out.println("하루를 마무리한다.");
	}
	
	public int around(ProceedingJoinPoint pjt) {
		int line =0;
		try {
			line = (int) pjt.proceed();
			this.afterReturning(line);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return line;
	}
}
