package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	//메서드 명은 중요한게 아니야! 직관적으로 보여주려고 이러한 이름을 사용함.
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}
	
	//정상 수행 후
	public void afterReturning(int line) {
		System.out.println("Git에 Push 한다. : "+line+"개의 줄을....");
	}
	//예외 발생 후
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if(th instanceof OuchException)
			((OuchException) th).handleException();
	}
	
	//이후에 
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}
	
	/////////////////////////////
	//aroud
	
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
