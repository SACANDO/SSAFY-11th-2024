package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	//method명은 중요하지 않아
	public void before() {
		System.out.println("컴퓨터 부팅");
		
	}
	
	//정상 수행 후
	public void afterReturning(int line) {
		System.out.println("git push : "+line+"개의 줄을...");
	}
	//예외 발생 후
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴");
		if(th instanceof OuchException)
			((OuchException) th).handleException();
	}
	
	//이후에
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
