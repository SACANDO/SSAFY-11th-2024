package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

//메모리 직접 저장해서 관리할 DB 같은 것!
//싱글턴! (김도은 아이디어~~)(
public class PersonManager {
	private List<Person> list = new ArrayList<>();
	private static PersonManager manager = new PersonManager();

	private PersonManager() {
	}

	public static PersonManager getInstance() {
		return manager;
	}

	public void regist(Person p) {
		list.add(p);
	}

	public List<Person> getAll() {
		return list;
	}

}
