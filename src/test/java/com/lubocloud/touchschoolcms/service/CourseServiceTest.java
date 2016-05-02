package com.lubocloud.touchschoolcms.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class CourseServiceTest {

	@Autowired
	CourseService courseService;
	
	@Test
	public void testAddCourseCategory() {
		Category cat = new Category();
		cat.setName("小学");
		cat.setParentCategory(courseService.getCourseCategory(0));
		courseService.addCourseCategory(cat);
	}

	@Test
	public void testDelCourseCategory() {
		courseService.delCourseCategory(3);;
	}

	@Test
	public void testEditCourseCategory() {
		Category cat = courseService.getCourseCategory(4);
		if(cat!=null)
		{
			cat.setName("初中");
			courseService.editCourseCategory(cat);
		}
	}

	@Test
	public void testGetCourseCategory() {
		Category cat = courseService.getCourseCategory(4);
		if(null!=cat){
			System.out.println("id: "+cat.getId()+"\tname: "+cat.getName());
		}
	}

	@Test
	public void testGetAllCourseCategory() {
		List<Category> catlist = courseService.getAllCourseCategory();
		if(null!=catlist){
			for(int i=0; i<catlist.size();i++){
				Category cat = catlist.get(i);
				System.out.println("id: "+cat.getId()+"\tname: "+cat.getName());
			}
		}
	}

	@Test
	public void testGetAllChildrenCategory() {
		String json = courseService.getAllChildrenCategoryWithJson(0);
		System.out.println(json);
	}

	@Test
	public void testGetDirectChildrenCategory() {
		String json = courseService.getDirectChildrenCategoryWithJson(5);
		System.out.println(json);
	}

	@Test
	public void testAddCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindVideo() {
		fail("Not yet implemented");
	}

}
