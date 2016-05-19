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
        ModelAndView model = new ModelAndView("admin/action-listcategory");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listcourse")
	public ModelAndView listCourse(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listcourse");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listvideo")
	public ModelAndView listVideo(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listvideo");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listlive")
	public ModelAndView listLive(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listlive");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 用户管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listgroupcategory")
	public ModelAndView listGroupCategory(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listcategory");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listgroup")
	public ModelAndView listGroup(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listgroup");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listrole")
	public ModelAndView listRole(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listrole");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listuser")
	public ModelAndView listUser(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listuser");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/liststudent")
	public ModelAndView listStudent(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-liststudent");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listteacher")
	public ModelAndView listTeacher(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listteacher");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
	/////////////////////////////////////////////////////////////////////////////////////
    //// 学科课本管理
    /////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value="/listpublisher")
	public ModelAndView listPublisher(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listpublisher");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listsubject")
	public ModelAndView listSuject(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listsubject");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listtextbook")
	public ModelAndView listTextbook(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listtextbook");
        model.addObject("contextPath", request.getContextPath());
		return model;
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
	public ModelAndView listClassroom(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listclassroom");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
    
    @RequestMapping(value="/listrbdevice")
	public ModelAndView listRBDevice(HttpServletRequest request)
	{
        ModelAndView model = new ModelAndView("admin/action-listrbdevice");
        model.addObject("contextPath", request.getContextPath());
		return model;
	}
}
