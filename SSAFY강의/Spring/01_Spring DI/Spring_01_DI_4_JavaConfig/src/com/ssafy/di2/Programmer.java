package com.ssafy.di2;

import org.springframework.stereotype.Component;

@Component
public class Programmer {
	private Computer computer;

	//생성자가 하나뿐이라 알잘로 들어가버리거임.
	// 생성자 주입
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	// 설정자 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}
