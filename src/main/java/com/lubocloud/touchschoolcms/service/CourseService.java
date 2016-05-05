package com.lubocloud.touchschoolcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.CourseDao;
import com.lubocloud.touchschoolcms.entity.Course;

@Service("courseService")
@Transactional
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseService()
	{
	}
	
	public void addCourse(Course course)
	{
		courseDao.save(course);
	}
	
	public void delCourse(int courseId)
	{
		courseDao.delete(courseId);
	}
	
	public void editCourse(Course course)
	{
		courseDao.update(course);
	}
	
	public Course findCourse(int courseId)
	{
		return courseDao.findById(courseId);
	}
	
}
