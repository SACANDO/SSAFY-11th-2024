package com.ssafy.di3_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		//의존관계역전을 맛을 보았다.
		
		//스프링 컨테이너가 이러한 것들을 해줘!!
		Desktop desktop = new Desktop();
		Programmer p = new Programmer(desktop);
		
		p.coding();
		
		
		
		Laptop laptop = new Laptop();
		Programmer p2 = new Programmer(laptop);
		
		p2.coding();
	}
}