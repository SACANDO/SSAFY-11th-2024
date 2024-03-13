package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ControllerParameter {
	
	@GetMapping("/test1") //요청 경로
	public String test1() { //메서드명은 지금은 중요치 않아.
		
		//반환타입이 String이라는 뜻은 해당값이 ViewName이다.
		return "test1"; //WEB-INF/view/test1.jsp
	}
	
	
	//데이터를 실어서 보내고 싶은데, ModelAndView로 하긴 싫어
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		model.addAttribute("msg", "데이터야");
		return "test2";
	}
	
	//데이터를 실어서 보내고 싶은데, ModelAndView로 하긴 싫어
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		model.put("msg", "데이터야2");
		return "test2";
	}
	
	
//	//파라미터로 값을 가져오고 싶다.
//	@GetMapping("/test3")
//	public String test3(Model model, HttpServletRequest request) {
//		String id = request.getParameter("id");
//		
//		model.addAttribute("id", id);
//		return "test3";
//	}
	//파라미터로 값을 가져오고 싶다.
	@GetMapping("/test3")
	public String test3(Model model, @RequestParam("myid") String id, @RequestParam(value="pw", defaultValue = "1234") String pw) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "test3";
	}
	
	
	
	
	
	
	
	
	
}
