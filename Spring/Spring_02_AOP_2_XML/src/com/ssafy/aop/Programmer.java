package com.ssafy.aop;

import java.util.Random;

import com.ssafy.aop.Person;

public class Programmer implements Person {
	// 필드는 과감히 생략~

	public int coding() {

		
		if(new Random().nextBoolean())
			throw new OuchException();
		System.out.println("열심히 코드 작성"); // 핵심관심사항
		return (int)(Math.random()*100)+1;
	}
}
