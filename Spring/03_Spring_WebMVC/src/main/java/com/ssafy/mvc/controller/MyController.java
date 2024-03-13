package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView homeHandle1() {
		ModelAndView mav = new ModelAndView();
		//데이터를 실어서 보내보자. (키/벨류)
		mav.addObject("msg", "Welcome to Spring (GET)");
		
		//view 이름을 결정해야해 //포워딩 한것과 같음
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping(value="home", method = RequestMethod.POST)
	public ModelAndView homeHandle2() {
		ModelAndView mav = new ModelAndView();
		//데이터를 실어서 보내보자. (키/벨류)
		mav.addObject("msg", "Welcome to Spring (POST)");
		
		//view 이름을 결정해야해 //포워딩 한것과 같음
		mav.setViewName("home");
		return mav;
	}
	
	
	
	
	
}
