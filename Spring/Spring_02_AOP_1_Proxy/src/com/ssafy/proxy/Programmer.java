package com.ssafy.proxy;

import java.util.Random;

import com.ssafy.proxy2.Person;

public class Programmer{
	//필드는 과감히 생략~
	
	public void coding() {
		 System.out.println("컴퓨터 부팅"); //이전에 수행해야할 사항
		 
		 try {
			 System.out.println("열심히 코드 작성"); //핵심관심사항
			 
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
