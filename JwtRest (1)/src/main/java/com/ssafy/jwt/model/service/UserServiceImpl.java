package com.ssafy.jwt.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.jwt.model.dao.UserDao;
import com.ssafy.jwt.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDto loginUser(UserDto userDto) {
		return userDao.loginUser(userDto);
	}

}
