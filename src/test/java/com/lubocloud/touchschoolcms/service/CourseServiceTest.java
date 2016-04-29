package com.lubocloud.touchschoolcms.service;

import static org.junit.Assert.*;

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
	public void testCourseService() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCourseCategory() {
		Category cat = new Category();
		cat.setName("高中");
		courseService.addCourseCategory(cat);
	}

	@Test
	public void testDelCourseCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditCourseCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCourseCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllChildrenCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDirectChildrenCategory() {
		fail("Not yet implemented");
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
