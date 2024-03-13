package com.ssafy.proxy2;

public class Test {
	public static void main(String[] args) {
	
		PersonProxy px = new PersonProxy();
		px.setPerson(new Programmer());
		px.coding();
		
		
	}
}
