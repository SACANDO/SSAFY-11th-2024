package com.ssafy.aop;

import java.util.Random;

import com.ssafy.aop.Person;

public class Ssafy implements Person {
	// 필드는 과감히 생략~

	public int coding() {

		System.out.println("열심히 공부"); // 핵심관심사항
		if(new Random().nextBoolean())
			throw new OuchException();
		return (int)(Math.random()*100)+1;
	}
}
