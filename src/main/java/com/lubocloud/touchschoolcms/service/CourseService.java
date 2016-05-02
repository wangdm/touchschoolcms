package com.lubocloud.touchschoolcms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.CategoryDao;
import com.lubocloud.touchschoolcms.dao.CourseDao;
import com.lubocloud.touchschoolcms.dao.VideoDao;
import com.lubocloud.touchschoolcms.entity.Category;
import com.lubocloud.touchschoolcms.entity.Category.CategoryType;
import com.lubocloud.touchschoolcms.entity.Course;
import com.lubocloud.touchschoolcms.entity.Video;

@Service("courseService")
@Transactional
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
    
	public List<Category> getAllCourseCategory()
	{
		return categoryDao.findByColumn("type", CategoryType.Course);
	}
    
	public String getAllChildrenCategoryWithJson(int categoryId)
	{
        String jsonStr = null;
        if(categoryId>0){
            Category parentCat = categoryDao.findById(categoryId);
            if(parentCat==null){
            	return null;
            }
            jsonStr = "{\"name\":\""+parentCat.getName()+"\", \"id\":"+parentCat.getId();
        }else{
	        jsonStr = "{\"name\":\"在线学习平台\", \"id\":0";
        }
        List<Category> catlist = categoryDao.findByColumn("type", CategoryType.Course);
        if(catlist!=null && catlist.size()>0){
        	String childStr = recursionCategory(catlist, categoryId);
        	if(childStr!=null)
        	{
        		jsonStr += childStr;
        	}
        }
        jsonStr += "}";
		return jsonStr;
	}
	
	private String recursionCategory(List<Category> catlist, int parentId)
	{
		String jsonStr = null;
		List<Category> childCatList = new ArrayList<Category>();
    	for(int i=0; i<catlist.size(); i++)
    	{
    		Category childCat = catlist.get(i);
    		if( (parentId<=0&&childCat.getParentCategory()==null) || (childCat.getParentCategory()!=null&&parentId==childCat.getParentCategory().getId()) )
    		{
    			childCatList.add(childCat);
    		}
    	}
		if(childCatList.size()>0)
		{
			jsonStr = ", \"children\":[";
			for(int i=0; i<childCatList.size(); i++)
			{
	    		Category childCat = childCatList.get(i);
	    		jsonStr += "{\"name\":\""+childCat.getName()+"\",\"id\":"+childCat.getId();
	    		String childStr = recursionCategory(catlist, childCat.getId());
	    		if(childStr!=null){
	    			jsonStr += childStr;
	    		}
	    		if(i==childCatList.size()-1){
	    			jsonStr += "}";
	    		}else{
	    			jsonStr += "},";
	    		}
			}
	    	jsonStr += "]";
		}
		return jsonStr;
	}
    
	public String getDirectChildrenCategoryWithJson(int categoryId)
	{
        String jsonStr = null;
        Category parentCat = categoryDao.findById(categoryId);
        if(parentCat!=null){
            jsonStr = "{\"name\":\""+parentCat.getName()+"\", \"id\":"+parentCat.getId();
            List<Category> catlist = categoryDao.findByColumn("parentCategory.id", categoryId);
            if(catlist!=null && catlist.size()>0){
            	jsonStr += ", \"children\":[";
            	for(int i=0; i<catlist.size(); i++){
            		Category childCat = catlist.get(i);
            		jsonStr += "{\"name\":\""+childCat.getName()+"\",\"id\":"+childCat.getId();
            		if(i==catlist.size()-1){
            			jsonStr += "}";
            		}else{
            			jsonStr += "},";
            		}
            	}
    			jsonStr += "]";
            }
			jsonStr += "}";
        }
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
