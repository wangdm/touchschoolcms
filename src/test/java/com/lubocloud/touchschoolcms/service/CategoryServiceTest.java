package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class CategoryServiceTest {

	@Autowired
	CategoryService categoryService;
	
	@Test
	public void testAddCourseCategory() {
		Category cat = new Category();
		cat.setName("小学");
		cat.setParentCategory(categoryService.getCourseCategory(0));
		categoryService.addCourseCategory(cat);
	}

	@Test
	public void testDelCourseCategory() {
		categoryService.delCourseCategory(3);;
	}

	@Test
	public void testEditCourseCategory() {
		Category cat = categoryService.getCourseCategory(4);
		if(cat!=null)
		{
			cat.setName("初中");
			categoryService.editCourseCategory(cat);
		}
	}

	@Test
	public void testGetCourseCategory() {
		Category cat = categoryService.getCourseCategory(4);
		if(null!=cat){
			System.out.println("id: "+cat.getId()+"\tname: "+cat.getName());
		}
	}

	@Test
	public void testGetAllCourseCategory() {
		List<Category> catlist = categoryService.getAllCourseCategory();
		if(null!=catlist){
			for(int i=0; i<catlist.size();i++){
				Category cat = catlist.get(i);
				System.out.println("id: "+cat.getId()+"\tname: "+cat.getName());
			}
		}
	}

	@Test
	public void testGetAllChildrenCategory() {
		String json = categoryService.getAllChildrenCategoryWithJson(0);
		System.out.println(json);
	}

	@Test
	public void testGetDirectChildrenCategory() {
		String json = categoryService.getDirectChildrenCategoryWithJson(5);
		System.out.println(json);
	}

}
