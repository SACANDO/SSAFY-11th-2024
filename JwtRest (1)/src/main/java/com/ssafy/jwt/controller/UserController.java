package com.ssafy.jwt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jwt.annotation.AuthRequired;
import com.ssafy.jwt.model.dto.UserDto;
import com.ssafy.jwt.model.service.UserService;
import com.ssafy.jwt.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Value("${jwt.refreshtoken.expiretime}")
	private int refreshTokenExpireTime;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpServletResponse response) throws UnsupportedEncodingException{
		
		Map<String, Object> result = new HashMap<>();
		
		// DB에서 유저 가져오기
		UserDto dbUser = userService.loginUser(userDto);
		
		// 일치하는 유저가 없다면 UNAUTHORIZED 반환.
		if(dbUser == null) {
			result.put("message", "일치하는 유저가 없습니다.");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
		}
		
		// 있으면 Token 발급
		// AccessToken, RefreshToken 두 개를 발급해준다.
		String accessToken = jwtUtil.createAccessToken(dbUser.getId());
		String refreshToken = jwtUtil.createRefreshToken(dbUser.getId());
		
		// Front End와 합의사항
		//1.) accessToken, refreshToken => 본문에 둘다 보내도 되고,
		//   refreshToken: localStorage에 저장, accessToken: sessionStorage 또는 pinia store에만.
		
		//2.) accessToken만 응답 본문에 넣어서 보내고, refreshToken은 쿠키에 넣어서 보냄. => 
		//  refreshToken은 브라우저에 자동 저장
		//  accessToken만 sessionStorage 또는 pinia store에 저장.
		
		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setMaxAge(refreshTokenExpireTime);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		result.put("accessToken", accessToken);
		result.put("name", dbUser.getName());
		
		
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	
	@AuthRequired // 토큰이 있어야지만 접근 가능한 메서드.
	@GetMapping("/mypage")
	ResponseEntity<?> mypage(){
		
		return null;
	}

	
}
