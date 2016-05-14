package com.lubocloud.touchschoolcms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request){
        ModelAndView model = new ModelAndView("index");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_index", "selected");
        User curuser = (User)request.getSession().getAttribute("curuser");
        if(curuser!=null){
        	model.addObject("curuser", curuser);
        }
		//TODO
		return model;
	}
	
	@RequestMapping(value="/lives", method=RequestMethod.GET)
	public ModelAndView listLives(HttpServletRequest request){
        ModelAndView model = new ModelAndView("lives");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_live", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/live/{id}", method=RequestMethod.GET)
	public ModelAndView currentLive(@PathVariable("id") Integer id, HttpServletRequest request){
        ModelAndView model = new ModelAndView("live");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_live", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/courses", method=RequestMethod.GET)
	public ModelAndView listCourse(HttpServletRequest request){
        ModelAndView model = new ModelAndView("courses");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_course", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/course/{id}", method=RequestMethod.GET)
	public ModelAndView currentCourse(@PathVariable("id") Integer id,HttpServletRequest request){
        ModelAndView model = new ModelAndView("course");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_course", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/videos", method=RequestMethod.GET)
	public ModelAndView listVideo(HttpServletRequest request){
        ModelAndView model = new ModelAndView("videos");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_video", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.GET)
	public ModelAndView currentVideo(@PathVariable("id") Integer id, HttpServletRequest request){
        ModelAndView model = new ModelAndView("video");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_video", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ModelAndView listBook(HttpServletRequest request){
        ModelAndView model = new ModelAndView("books");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_book", "selected");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public ModelAndView currentBook(@PathVariable("id") Integer id, HttpServletRequest request){
        ModelAndView model = new ModelAndView("book");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_book", "selected");
		//TODO
		return model;
	}
}
