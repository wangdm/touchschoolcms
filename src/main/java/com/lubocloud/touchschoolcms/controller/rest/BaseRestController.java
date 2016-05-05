package com.lubocloud.touchschoolcms.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubocloud.touchschoolcms.service.CourseService;
import com.lubocloud.touchschoolcms.service.ScheduleService;
import com.lubocloud.touchschoolcms.service.SubjectService;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class BaseRestController {

	@Autowired
	CourseService courseService;
    
	@Autowired
	UserService userService;
    
	@Autowired
	SubjectService subjectService;
    
	@Autowired
	ScheduleService scheduleService;

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
}
