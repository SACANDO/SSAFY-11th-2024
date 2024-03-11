package com.safy.di2_객체의존성제거;

public class Test {
	public static void main(String[] args) {
		
		//스프링 컨테이너가 이런 것들을 해줘
		//Programmer -> Test로 의존관계 역전
		Desktop desktop = new Desktop();
		
		Programmer p = new Programmer(desktop);
		
		p.coding();
	}
}
