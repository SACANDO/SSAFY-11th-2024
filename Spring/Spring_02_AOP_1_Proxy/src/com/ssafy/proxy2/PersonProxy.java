package com.ssafy.proxy2;

import java.util.Random;

import com.ssafy.proxy.OuchException;

public class PersonProxy implements Person{
	
	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		 System.out.println("컴퓨터 부팅"); //이전에 수행해야할 사항
		 
		 try {
			  //핵심관심사항
			 person.coding();
			 if(new Random().nextBoolean()) {
				 throw new OuchException();
			 }
			 System.out.println("git push"); //이상 없이 마무리가 되었을 때
		 } catch(OuchException e) {
			 System.out.println("조퇴"); //예외 발생
			 e.handleException();
		 } finally {
			 System.out.println("하루 마무리"); //모든 게 마무리 되었을 때		 
		 }
		 
	}
}
