package com.ssafy.di4_의존성주입;

public class Programmer {
	private Computer computer;
	
	public Programmer() {
	}
	
	//생성자 주입
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	//설정자 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
//	//메서드 주입 (여러개를 동시에 주입하려고 할때)
//	public void init(Computer computer, Keyboard keyboard) {
//		this.computer = computer;
//		this.keyboard = keyboard;
//	}
	
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
