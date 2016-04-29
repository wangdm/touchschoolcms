package com.lubocloud.touchschoolcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.service.CourseService;
import com.lubocloud.touchschoolcms.service.ScheduleService;
import com.lubocloud.touchschoolcms.service.SubjectService;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CourseService courseService;
    
	@Autowired
	UserService userService;
    
	@Autowired
	SubjectService subjectService;
    
	@Autowired
	ScheduleService scheduleService;
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 课程管理
    /////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/listcoursecategory")
	public ModelAndView listCourseCategory()
	{
        ModelAndView modal = new ModelAndView("action-listcategory");
		return modal;
	}
    
    @RequestMapping(value="/listcourse")
	public ModelAndView listCourse()
	{
        ModelAndView modal = new ModelAndView("action-listcourse");
		return modal;
	}
    
    @RequestMapping(value="/listvideo")
	public ModelAndView listVideo()
	{
        ModelAndView modal = new ModelAndView("action-listvideo");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 用户管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listgroupcategory")
	public ModelAndView listGroupCategory()
	{
        ModelAndView modal = new ModelAndView("action-listcategory");
		return modal;
	}
    
    @RequestMapping(value="/listgroup")
	public ModelAndView listGroup()
	{
        ModelAndView modal = new ModelAndView("action-listgroup");
		return modal;
	}
    
    @RequestMapping(value="/listuser")
	public ModelAndView listUser()
	{
        ModelAndView modal = new ModelAndView("action-listuser");
		return modal;
	}
    
    @RequestMapping(value="/liststudent")
	public ModelAndView listStudent()
	{
        ModelAndView modal = new ModelAndView("action-liststudent");
		return modal;
	}
    
    @RequestMapping(value="/listteacher")
	public ModelAndView listTeacher()
	{
        ModelAndView modal = new ModelAndView("action-listteacher");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 学科课本管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listpublisher")
	public ModelAndView listPublisher()
	{
        ModelAndView modal = new ModelAndView("action-listpublisher");
		return modal;
	}
    
    @RequestMapping(value="/listsubject")
	public ModelAndView listSuject()
	{
        ModelAndView modal = new ModelAndView("action-listsubject");
		return modal;
	}
    
    @RequestMapping(value="/listtextbook")
	public ModelAndView listTextbook()
	{
        ModelAndView modal = new ModelAndView("action-listtextbook");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 课表管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/queryteacherschedule")
	public ModelAndView queryTeacherSchedule()
	{
        ModelAndView modal = new ModelAndView("action-queryteacherschedule");
		return modal;
	}
    
    @RequestMapping(value="/querygroupschedule")
	public ModelAndView queryGroupSchedule()
	{
        ModelAndView modal = new ModelAndView("action-querygroupschedule");
		return modal;
	}
}
