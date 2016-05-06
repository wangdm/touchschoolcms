package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.CourseDao;
import com.lubocloud.touchschoolcms.entity.Category;
import com.lubocloud.touchschoolcms.entity.Course;
import com.lubocloud.touchschoolcms.entity.Textbook;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.entity.Video;
import com.lubocloud.touchschoolcms.utils.Page;

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
	
	public List<Course> listCourse(Category category, String title, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Video> listVideo(Course course)
	{
		//TODO
		return null;
	}
	
	public List<Course> listCourse(User user, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Course> listVideo(Textbook book, Page page)
	{
		//TODO
		return null;
	}
	
	public String getCoursesWithJson(int catId, String title, Page page)
	{
		//TODO
		return null;
	}
	
	public String getVideosWithJsonByCourse(int cid, Page page)
	{
		//TODO
		return null;
	}
	
	public String getCoursesWithJsonByUser(int uid, Page page)
	{
		//TODO
		return null;
	}
	
	public String getCoursesWithJsonByTextbook(int textbookId, Page page)
	{
		//TODO
		return null;
	}
	
}
