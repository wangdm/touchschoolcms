package com.lubocloud.touchschoolcms.controller.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lubocloud.touchschoolcms.entity.Category;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class CategoryRestController extends BaseRestController {
	
	@RequestMapping(value="/categorys",method=RequestMethod.GET)
	@ResponseBody
	public String getAllCategory(){
		return this.getCourseService().getAllChildrenCategoryWithJson(0);
	}
	
	@RequestMapping(value="/categorys",method=RequestMethod.POST)
	@ResponseBody
	public String addCategory(@RequestBody Category cat, HttpServletResponse response) throws IOException{
		if(cat==null){
			response.sendError(401);
			return null;
		}
		System.out.println("add category "+cat.getName());
		this.getCourseService().addCourseCategory(cat);
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
		Category category = this.getCourseService().getCourseCategory(catId);
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
		Category category = this.getCourseService().getCourseCategory(cat.getId());
		if(category!=null){
			category.setName(cat.getName());
			this.getCourseService().editCourseCategory(category);
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
		this.getCourseService().delCourseCategory(catId);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/allchildrencategorys/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getAllChildrenCategory(@PathVariable("id") Integer id){
		int catId = 0;
		if(id==null || id.intValue()<0){
			catId = 0;
		}
		return this.getCourseService().getAllChildrenCategoryWithJson(catId);
	}
	
	@RequestMapping(value="/directchildrencategorys/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getDirectChildrenCategory(@PathVariable("id") Integer id){
		int catId = 0;
		if(id==null || id.intValue()<0){
			catId = 0;
		}
		return this.getCourseService().getDirectChildrenCategoryWithJson(catId);
	}
	
}
