package com.lubocloud.touchschoolcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	UserService userService;

	//登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(){
		return null;
	}
	//注册
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(){
		return null;
	}
	
	@RequestMapping(value="/member")
	public ModelAndView memberCenter(){
        ModelAndView model = new ModelAndView("member/index");
		return model;
	}
}
