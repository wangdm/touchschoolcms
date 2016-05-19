package com.lubocloud.touchschoolcms.controller.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.service.UserService;
import com.lubocloud.touchschoolcms.utils.Page;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class UserRestController extends BaseRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	@ResponseBody
	public String getAllUser( HttpServletRequest request){
		int groupId = 0;
		int roleId = 0;
		int pageNum = 0;
		String strParam;
		strParam = request.getParameter("gid");
		if(strParam!=null && !strParam.equals("")){
			groupId = Integer.parseInt(strParam);
		}
		strParam = request.getParameter("rid");
		if(strParam!=null && !strParam.equals("")){
			roleId = Integer.parseInt(strParam);
		}
		strParam = request.getParameter("page");
		if(strParam!=null && !strParam.equals("")){
			pageNum = Integer.parseInt(strParam);
		}
		Page page = new Page();
		page.setCurrentPage(pageNum);
		
		return userService.getUsersWithJson(groupId,roleId,page);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user, HttpServletResponse response) throws IOException{
		if(user==null){
			response.sendError(401);
			return null;
		}
		System.out.println("add user "+user.getUsername());
		userService.addUser(user);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int userId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			userId = id.intValue();
		}
		User user = userService.findUser(userId);
		if(user!=null){
			String jsonStr = "{\"name\": \"}"+user.getUsername()+"\", \"id\":"+user.getUid();
			return jsonStr;
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateUser(@RequestBody User user, HttpServletResponse response) throws IOException{
		if(user==null || user.getUid()<=0){
			response.sendError(401);
			return null;
		}
		User _user = userService.findUser(user.getUid());
		if(_user!=null){
			_user.setUsername(user.getUsername());
			userService.editUser(_user);
			return "{\"result\":\"success\"}";
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delUser(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int userId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			userId = id.intValue();
		}
		userService.delUser(userId);
		return "{\"result\":\"success\"}";
	}
}
