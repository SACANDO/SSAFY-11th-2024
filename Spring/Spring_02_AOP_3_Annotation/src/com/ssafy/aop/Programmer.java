package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.ssafy.aop.Person;

@Component
public class Programmer implements Person {
	// 필드는 과감히 생략~

	public int coding() {

		System.out.println("열심히 코드 작성"); // 핵심관심사항
		if(new Random().nextBoolean())
			throw new OuchException();
		return (int)(Math.random()*100)+1;
	}
}
