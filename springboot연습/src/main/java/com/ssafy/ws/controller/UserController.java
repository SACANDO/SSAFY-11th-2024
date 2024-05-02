package com.ssafy.ws.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user-api")
public class UserController {

	@Autowired
	UserService us;

	private HttpStatus httpstatus(int result) {
		return result !=0? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	}

	private String msg(int result) {
		return result !=0? "성공" : "실패";
	}


	
	//로그인 배우고 하기
//	@PostMapping
//	public ResponseEntity<?> loginV2() {
//		// 작성하기
//		boolean result = false;
//		
//		return new ResponseEntity<>(msg(result), httpstatus(result));
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> checkJwt() {
//		// 작성하기
//		boolean result = false;
//		
//		return new ResponseEntity<>(msg(result), httpstatus(result));
//	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping ({"/",""})
	public ResponseEntity<?> userlist() {

		List<User> users = us.selectAll();
		
		return new ResponseEntity<List<User>> (users, HttpStatus.OK);
		
	}
	
	
	
	
	//checkpassword,, 왜 하는 건지 일단 모르겠음
	@PostMapping ("/check-password")
	public ResponseEntity<?> checkPassword(@RequestBody User user) {

		// 해당 id를 가진 유저를 찾는다.
		// 유저가 있으면 true 없으면 false
		// 해당 id를 가진 유저의 비밀번호와 입력된 비밀번호를 비교한다.
		// 매칭 성공이면 true를 반환

		User u = us.SearchById(user.getId());
		int result = 0;
		if (user.getUserPwd().equals(u.getUserPwd())) {
			result = 1;
		}
		return new ResponseEntity<>("로그인"+msg(result), httpstatus(result));
	}
	
	//login
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		// 작성하기
		int result = 0;
		User u = us.SearchById(user.getId());
		if(u!=null) { 
			System.out.println("아이디는 맞아");
			System.out.println(u.getUserPwd());
			System.out.println(user.getUserPwd());
			if(user.getUserPwd().equals(u.getUserPwd())) 
				result = 1;
				session.setAttribute("user", user);
				return new ResponseEntity<>(u.getUserName()+"님 로그인" + msg(result), httpstatus(result));	
					
		} 
		return new ResponseEntity<>("로그인" + msg(result), httpstatus(result));
	}

	//signup
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {

		
		int result = 0;
		// 중복되는 아이디 거르기
		if(us.SearchById(user.getId())==null) { 
			result =1;
			us.signup(user);
			return new ResponseEntity<>("회원가입 "+msg(result), httpstatus(result));
		} else {
			return new ResponseEntity<>("아이디 중복, 회원가입 "+msg(result), httpstatus(result));
			// 나중에 alert로 아이디 중복 띄우고 다시 회원가입 할 수 있도록 하기
		}
		

	}

	@DeleteMapping("/{userSeq}")
	public ResponseEntity<?> delete(@PathVariable("userSeq") int userSeq) {
		int result = us.delete(userSeq);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}

	@PutMapping("/{userSeq}")
	public ResponseEntity<?> update(@PathVariable("userSeq") int userSeq, @RequestBody User user) {
		user.setUserSeq(userSeq);
		int result = us.update(user);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}
}
