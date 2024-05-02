package com.ssafy.ws.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public int delete(int userSeq) {

		return userDao.delete(userSeq);
	}

	@Override
	public int update(User user) {

		return userDao.update(user);
	}





	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}





	@Override
	public void signup(User user) {
		user.setJoinedAt(new Date());
		userDao.signup(user);
	}



	@Override
	public User SearchById(String id) {
		return userDao.searchById(id);
	}



	@Override
	public boolean checkJwt() {
		// TODO 나중에
		return false;
	}

	
	@Override
	public User loginV2(User user) {
		// TODO 나중에
		return null;
	}



	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}
}
