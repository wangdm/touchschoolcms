package com.lubocloud.touchschoolcms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lubocloud.touchschoolcms.entity.Lesson;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.service.CourseService;
import com.lubocloud.touchschoolcms.service.LessonService;
import com.lubocloud.touchschoolcms.service.ScheduleService;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CourseService courseService;
    
	@Autowired
	UserService userService;
    
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	LessonService lessonService;

	@RequestMapping(value="")
	public ModelAndView dashboard(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/index");
        model.addObject("contextPath", request.getContextPath());
        User curuser = (User)request.getSession().getAttribute("curuser");
        if(curuser!=null){
        	model.addObject("curuser", curuser);
        }
		return model;
	}
	/////////////////////////////////////////////////////////////////////////////////////
    //// 课程管理
    /////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/listcoursecategory")
	public ModelAndView listCourseCategory(HttpServletRequest request)
	{
        ModelAndView modal = new ModelAndView("admin/action-listcategory");
        modal.addObject("contextPath", request.getContextPath());
		return modal;
	}
    
    @RequestMapping(value="/listcourse")
	public ModelAndView listCourse()
	{
        ModelAndView modal = new ModelAndView("admin/action-listcourse");
		return modal;
	}
    
    @RequestMapping(value="/listvideo")
	public ModelAndView listVideo()
	{
        ModelAndView modal = new ModelAndView("admin/action-listvideo");
		return modal;
	}
    
    @RequestMapping(value="/listlive")
	public ModelAndView listLive()
	{
        ModelAndView modal = new ModelAndView("admin/action-listlive");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 用户管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listgroupcategory")
	public ModelAndView listGroupCategory()
	{
        ModelAndView modal = new ModelAndView("admin/action-listcategory");
		return modal;
	}
    
    @RequestMapping(value="/listgroup")
	public ModelAndView listGroup()
	{
        ModelAndView modal = new ModelAndView("admin/action-listgroup");
		return modal;
	}
    
    @RequestMapping(value="/listrole")
	public ModelAndView listRole()
	{
        ModelAndView modal = new ModelAndView("admin/action-listrole");
		return modal;
	}
    
    @RequestMapping(value="/listuser")
	public ModelAndView listUser()
	{
        ModelAndView modal = new ModelAndView("admin/action-listuser");
		return modal;
	}
    
    @RequestMapping(value="/liststudent")
	public ModelAndView listStudent()
	{
        ModelAndView modal = new ModelAndView("admin/action-liststudent");
		return modal;
	}
    
    @RequestMapping(value="/listteacher")
	public ModelAndView listTeacher()
	{
        ModelAndView modal = new ModelAndView("admin/action-listteacher");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 学科课本管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listpublisher")
	public ModelAndView listPublisher()
	{
        ModelAndView modal = new ModelAndView("admin/action-listpublisher");
		return modal;
	}
    
    @RequestMapping(value="/listsubject")
	public ModelAndView listSuject()
	{
        ModelAndView modal = new ModelAndView("admin/action-listsubject");
		return modal;
	}
    
    @RequestMapping(value="/listtextbook")
	public ModelAndView listTextbook()
	{
        ModelAndView modal = new ModelAndView("admin/action-listtextbook");
		return modal;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 课表管理
    /////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value="/listlesson")
	public ModelAndView listLesson(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listlesson");
        model.addObject("contextPath", request.getContextPath());
        List<Lesson> lessonList= lessonService.listAllLesson();
        model.addObject("lessonList", lessonList);
		return model;
	}
    
    @RequestMapping(value="/queryteacherschedule")
	public ModelAndView queryTeacherSchedule(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-queryteacherschedule");
        model.addObject("contextPath", request.getContextPath());
        List<Lesson> lessonList= lessonService.listAllLesson();
        model.addObject("lessonList", lessonList);
		return model;
	}
    
    @RequestMapping(value="/querygroupschedule")
	public ModelAndView queryGroupSchedule(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-querygroupschedule");
        model.addObject("contextPath", request.getContextPath());
        List<Lesson> lessonList= lessonService.listAllLesson();
        model.addObject("lessonList", lessonList);
		return model;
	}
    
    @RequestMapping(value="/queryclassschedule")
	public ModelAndView queryClassSchedule(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-queryclassschedule");
        model.addObject("contextPath", request.getContextPath());
        List<Lesson> lessonList= lessonService.listAllLesson();
        model.addObject("lessonList", lessonList);
		return model;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 设备管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listclassroom")
	public ModelAndView listClassroom()
	{
        ModelAndView modal = new ModelAndView("admin/action-listclassroom");
		return modal;
	}
    
    @RequestMapping(value="/listrbdevice")
	public ModelAndView listRBDevice()
	{
        ModelAndView modal = new ModelAndView("admin/action-listrbdevice");
		return modal;
	}
}
