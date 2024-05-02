package com.ssafy.ws.service;

import java.util.List;

import com.ssafy.ws.model.dto.User;

public interface UserService {

	int delete(int user_seq);

	int update(User user);

	boolean checkJwt(); //나중에
	
	User SearchById(String id);
	
	User login(User user);
	
	User loginV2(User user);
	
	void signup(User user);
	
	List<User> selectAll();

}
