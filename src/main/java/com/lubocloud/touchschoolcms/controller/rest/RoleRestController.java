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

import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.service.RoleService;
import com.lubocloud.touchschoolcms.utils.Page;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class RoleRestController extends BaseRestController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/roles",method=RequestMethod.GET)
	@ResponseBody
	public String getAllRole(){
		Page page = new Page();
		page.setCurrentPage(0);
		return roleService.listRoleWithJson(page);
	}
	
	@RequestMapping(value="/roles",method=RequestMethod.POST)
	@ResponseBody
	public String addRole(@RequestBody Role role, HttpServletResponse response) throws IOException{
		if(role==null){
			response.sendError(401);
			return null;
		}
		System.out.println("add role "+role.getName());
		roleService.addRole(role);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/roles/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getRole(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int roleId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			roleId = id.intValue();
		}
		Role role = roleService.findRole(roleId);
		if(role!=null){
			String jsonStr = "{\"name\": \"}"+role.getName()+"\", \"id\":"+role.getId();
			return jsonStr;
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/roles/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateRole(@RequestBody Role role, HttpServletResponse response) throws IOException{
		if(role==null || role.getId()<=0){
			response.sendError(401);
			return null;
		}
		Role _role = roleService.findRole(role.getId());
		if(_role!=null){
			_role.setName(role.getName());
			roleService.editRole(_role);
			return "{\"result\":\"success\"}";
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/roles/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delRole(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int roleId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			roleId = id.intValue();
		}
		roleService.delRole(roleId);
		return "{\"result\":\"success\"}";
	}
}
