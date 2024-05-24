package com.ssafy.jwt.model.service;

import com.ssafy.jwt.model.dto.UserDto;

public interface UserService {
	UserDto loginUser(UserDto userDto);
}
