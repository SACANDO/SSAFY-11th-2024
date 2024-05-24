package com.ssafy.jwt.model.dao;

import com.ssafy.jwt.model.dto.UserDto;

public interface UserDao {
	UserDto loginUser(UserDto userDto);
}
