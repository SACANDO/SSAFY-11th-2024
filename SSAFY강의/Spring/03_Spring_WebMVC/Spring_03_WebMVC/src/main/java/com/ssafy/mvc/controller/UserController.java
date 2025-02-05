package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

@Controller
public class UserController {

	@GetMapping("/regist")
	public String registform() {
		return "regist";
	}

//	@PostMapping("/regist")
//	public String regist(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		// 요기서 하는게 아니라 서비스를 호출
//		User user = new User(id, pw);
//
//		System.out.println(user);
//		return "result";
//	}
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user) {
		// 요기서 하는게 아니라 서비스를 호출
		System.out.println(user);
		return "result";
	}
}
