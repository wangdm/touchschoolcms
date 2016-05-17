package com.lubocloud.touchschoolcms.controller.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lubocloud.touchschoolcms.entity.Category;
import com.lubocloud.touchschoolcms.service.CategoryService;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class CategoryRestController extends BaseRestController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/categorys",method=RequestMethod.GET)
	@ResponseBody
	public String getAllCategory(){
		return categoryService.getAllChildrenCategoryWithJson(0);
	}
	
	@RequestMapping(value="/categorys",method=RequestMethod.POST)
	@ResponseBody
	public String addCategory(@RequestBody Category cat, HttpServletResponse response) throws IOException{
		if(cat==null){
			response.sendError(401);
			return null;
		}
		if(cat.getParentCategory()!=null&&cat.getParentCategory().getId()<=0)
		{
			cat.setParentCategory(null);
		}
		System.out.println("add category "+cat.getName());
		categoryService.addCourseCategory(cat);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/categorys/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getCategory(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int catId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			catId = id.intValue();
		}
		Category category = categoryService.getCourseCategory(catId);
		if(category!=null){
			String jsonStr = "{\"name\": \"}"+category.getName()+"\", \"id\":"+category.getId();
			return jsonStr;
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/categorys/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateCategory(@RequestBody Category cat, HttpServletResponse response) throws IOException{
		if(cat==null || cat.getId()<=0){
			response.sendError(401);
			return null;
		}
		Category category = categoryService.getCourseCategory(cat.getId());
		if(category!=null){
			category.setName(cat.getName());
			categoryService.editCourseCategory(category);
			return "{\"result\":\"success\"}";
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/categorys/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delCategory(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int catId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			catId = id.intValue();
		}
		categoryService.delCourseCategory(catId);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/allchildrencategorys/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getAllChildrenCategory(@PathVariable("id") Integer id){
		int catId = 0;
		if(id!=null && id.intValue()>0){
			catId = id.intValue();
		}
		return categoryService.getAllChildrenCategoryWithJson(catId);
	}
	
	@RequestMapping(value="/directchildrencategorys/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getDirectChildrenCategory(@PathVariable("id") Integer id){
		int catId = 0;
		if(id!=null && id.intValue()>0){
			catId = id.intValue();
		}
		return categoryService.getDirectChildrenCategoryWithJson(catId);
	}
	
}
