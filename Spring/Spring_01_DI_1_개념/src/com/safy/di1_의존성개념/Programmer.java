package com.safy.di1_의존성개념;

public class Programmer {
	private Desktop desktop;
	public Programmer() {
		//프로그래머 한 명이 새로 들어왔으니 컴퓨터 사서 제공
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발");
	}
}	
