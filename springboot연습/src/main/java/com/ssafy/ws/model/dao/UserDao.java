package com.ssafy.ws.model.dao;


import java.util.List;

import com.ssafy.ws.model.dto.User;

public interface UserDao {

	int delete(int userSeq);

	int update(User user);

	boolean checkJwt(); // 나중에

	User searchById(String id);

	User login(User user);

	User loginV2(User user);

	void signup(User user);
	
	List<User> selectAll();

}
