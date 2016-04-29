package com.lubocloud.touchschoolcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubocloud.touchschoolcms.dao.CategoryDao;
import com.lubocloud.touchschoolcms.dao.CourseDao;
import com.lubocloud.touchschoolcms.dao.VideoDao;
import com.lubocloud.touchschoolcms.entity.Category;
import com.lubocloud.touchschoolcms.entity.Category.CategoryType;
import com.lubocloud.touchschoolcms.entity.Course;
import com.lubocloud.touchschoolcms.entity.Video;

@Service
public class CourseService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private VideoDao videoDao;
	
	public CourseService()
	{
	}
	
	/*
	 *  Category
	 */
	public void addCourseCategory(Category category)
	{
		category.setType(CategoryType.Course);
		categoryDao.save(category);
	}
    
	public void delCourseCategory(int categoryId)
	{
		Category category = categoryDao.findById(categoryId);
        if(category != null){
            categoryDao.delete(categoryId);
        }
	}
	
	public void editCourseCategory(Category category)
	{
		categoryDao.update(category);
	}
    
	public Category getCourseCategory(int categoryId)
	{
		return categoryDao.findById(categoryId);
	}
    
	public String getAllChildrenCategory(int categoryId)
	{
        String jsonStr = null;
		return jsonStr;
	}
    
	public String getDirectChildrenCategory(int categoryId)
	{
        String jsonStr = null;
		return jsonStr;
	}
	
	/*
	 *  Course
	 */
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
	
	/*
	 *  Video
	 */
	public void addVideo(Video video)
	{
		videoDao.save(video);
	}
	
	public void delVideo(int videoId)
	{
		videoDao.delete(videoId);
	}
	
	public void editVideo(Video video)
	{
		videoDao.update(video);
	}
	
	public Video findVideo(int videoId)
	{
		return videoDao.findById(videoId);
	}
}
