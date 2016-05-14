package com.lubocloud.touchschoolcms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("")
public class MemberController {
	
	@Autowired
	UserService userService;

	//登录
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request){
        ModelAndView model = new ModelAndView("member/login");
        model.addObject("contextPath", request.getContextPath());
        if(request.getMethod()=="POST"){
            String username = request.getParameter("username");
            String passwd = request.getParameter("passwd");
            System.out.println("username："+username+"\tpassword："+passwd);
            User curuser = new User();
            curuser.setUsername(username);
            curuser.setPhone(passwd);
            request.getSession().setAttribute("curuser", curuser);
        	return new ModelAndView("redirect:/");
        }else{
            User curuser = (User)request.getSession().getAttribute("curuser");
            if(curuser==null){
        		return model;
            }else{
            	return new ModelAndView("redirect:/member");
            }
        }
		//TODO
	}
	//注册
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletRequest request){
        ModelAndView model = new ModelAndView("member/register");
        model.addObject("contextPath", request.getContextPath());
		//TODO
		return model;
	}
	//注销
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request){
        request.getSession().setAttribute("curuser", null);
        ModelAndView model = new ModelAndView("member/login");
        model.addObject("contextPath", request.getContextPath());
		//TODO
		return model;
	}
	
	@RequestMapping(value={"/member.jsp","/member.html","/member.htm"})
	public String memberCenterForward(HttpServletRequest request){
		return "redirect:/member";
	}
	
	@RequestMapping(value="/member")
	public ModelAndView memberCenter(HttpServletRequest request){
        ModelAndView model = new ModelAndView("member/index");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_index", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/message")
	public ModelAndView myMessage(HttpServletRequest request){
        ModelAndView model = new ModelAndView("member/message");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_message", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/favorite")
	public ModelAndView myFavorite(HttpServletRequest request, @RequestParam(name="type", required=false, defaultValue="course") String type){
        ModelAndView model = new ModelAndView("member/favorite");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_favorite", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/schedule")
	public ModelAndView mySchedule(HttpServletRequest request, @RequestParam(name="type", required=false, defaultValue="course") String type){
        ModelAndView model = new ModelAndView("member/schedule");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_schedule", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/live")
	public ModelAndView myLive(HttpServletRequest request, @RequestParam(name="action", required=false, defaultValue="list") String action){
        ModelAndView model = new ModelAndView("member/live");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_live", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/course")
	public ModelAndView myCourse(HttpServletRequest request, @RequestParam(name="action", required=false, defaultValue="list") String action){
        ModelAndView model = new ModelAndView("member/course");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_course", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/video")
	public ModelAndView myVideo(HttpServletRequest request, @RequestParam(name="action", required=false, defaultValue="list") String action){
        ModelAndView model = new ModelAndView("member/video");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_video", "select");
		//TODO
		return model;
	}
	
	@RequestMapping(value="/member/profile")
	public ModelAndView myProfile(HttpServletRequest request, @RequestParam(name="action", required=false, defaultValue="view") String action){
        ModelAndView model = new ModelAndView("member/profile");
        model.addObject("contextPath", request.getContextPath());
        model.addObject("menu_profile", "select");
		//TODO
		return model;
	}
}
