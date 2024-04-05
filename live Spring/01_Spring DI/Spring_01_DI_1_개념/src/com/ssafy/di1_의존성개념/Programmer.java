package com.ssafy.di1_의존성개념;

public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		//프로그래머 한명이 새로 들어왔으면 컴퓨터 하나 사서 제공해야함.!
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발을 합니다.");
	}
}
