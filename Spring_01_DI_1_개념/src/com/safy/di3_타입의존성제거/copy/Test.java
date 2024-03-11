package com.safy.di3_타입의존성제거.copy;

public class Test {
	public static void main(String[] args) {
		
		//스프링 컨테이너가 이런 것들을 해줘
		//Programmer -> Test로 의존관계 역전
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		Programmer p = new Programmer(desktop);
		p2.coding();
	}
}
