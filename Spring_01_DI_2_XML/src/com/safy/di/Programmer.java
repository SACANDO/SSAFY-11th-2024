package com.safy.di;

public class Programmer {
	private Computer computer;
	
	//객체 생성 의존성 제거
	public Programmer(Computer computer) {
		//프로그래머 한 명이 새로 들어왔으니 컴퓨터 사서 제공
		
		//직접 생성하는 것이 아닌, 데스크톱을 인자로 받아서 제공하겠다. 
		
		this.computer = computer;
	}
	public setComputer(Computer computer) {
		
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발");
	}
}	
