package com.lubocloud.touchschoolcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public ModelAndView userCenter(@PathVariable("username") String username){
        ModelAndView model = new ModelAndView("user/index");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/{username}/profile", method=RequestMethod.GET)
	public ModelAndView userProfile(@PathVariable("username") String username){
        ModelAndView model = new ModelAndView("user/index");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/{username}/course", method=RequestMethod.GET)
	public ModelAndView userCourse(@PathVariable("username") String username){
        ModelAndView model = new ModelAndView("user/index");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/{username}/video", method=RequestMethod.GET)
	public ModelAndView userVideo(@PathVariable("username") String username){
        ModelAndView model = new ModelAndView("user/index");
		//TODO
		return model;
	}
}
