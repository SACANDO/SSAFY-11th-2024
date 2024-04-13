package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String password) {
//		HttpSession session = request.getSession();
		//UserService라는것을 만들어서 호출 한다. 
		if(id.equals("ssafy") && password.equals("1234")) {
			//로그인 성공!
			session.setAttribute("id", id);
//			return "index"; //포워딩
			return "redirect:/";
		}
		//아니라면 다시 로그인페이지로 ㄱㄱ
		return "redirect:/login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("id"); id 지우기
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist";
	}
	
	
	
	
	
	
	
	
	
}
