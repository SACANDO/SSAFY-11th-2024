package com.ssafy.aop;

import java.util.Random;

import com.ssafy.aop.Person;

public class Ssafy implements Person {
	// 필드는 과감히 생략~

	public int coding() {

		
		if(new Random().nextBoolean())
			throw new OuchException();
		System.out.println("열심히 공부"); // 핵심관심사항
		return (int)(Math.random()*100)+1;
	}
}
