package com.ssafy.proxy2;

import java.util.Random;

public class PersonProxy implements Person {

	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	@Override
	// 프로그래머의 일상
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 수행해야할 친구
		try {
			person.coding(); // 핵심관심사항
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git에 Push 한다."); // 이상없이 마무리가 되었을 때
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴를 한다."); // 예외발생
		} finally {
			System.out.println("하루를 마무리한다."); // 모든게 마무리가 되었을 때
		}
	}

}
