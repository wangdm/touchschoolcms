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

import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.service.GroupService;

@Controller
@RequestMapping(value="/v1", produces="application/json; charset=UTF-8")
public class GroupRestController extends BaseRestController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value="/groups",method=RequestMethod.GET)
	@ResponseBody
	public String getAllCategory(){
		return groupService.getAllChildrenGroupWithJson(0);
	}
	
	@RequestMapping(value="/groups",method=RequestMethod.POST)
	@ResponseBody
	public String addGroup(@RequestBody Group group, HttpServletResponse response) throws IOException{
		if(group==null){
			response.sendError(401);
			return null;
		}
		if(group.getParentGroup()!=null&&group.getParentGroup().getGid()<=0)
		{
			group.setParentGroup(null);
		}
		System.out.println("add category "+group.getName());
		groupService.addGroup(group);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/groups/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getGroup(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int groupId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			groupId = id.intValue();
		}
		Group group = groupService.findGroup(groupId);
		if(group!=null){
			String jsonStr = "{\"name\": \"}"+group.getName()+"\", \"id\":"+group.getGid();
			return jsonStr;
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/groups/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateGroup(@RequestBody Group group, HttpServletResponse response) throws IOException{
		if(group==null || group.getGid()<=0){
			response.sendError(401);
			return null;
		}
		Group _group = groupService.findGroup(group.getGid());
		if(_group!=null){
			_group.setName(group.getName());
			groupService.editGroup(_group);
			return "{\"result\":\"success\"}";
		}else{
			response.sendError(404);
			return null;
		}
	}
	
	@RequestMapping(value="/groups/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delGroup(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		int groupId = 0;
		if(id==null || id.intValue()<0){
			response.sendError(401);
			return null;
		}else{
			groupId = id.intValue();
		}
		groupService.delGroup(groupId);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/allchildrengroups/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getAllChildrenGroup(@PathVariable("id") Integer id){
		int groupId = 0;
		if(id!=null && id.intValue()>0){
			groupId = id.intValue();
		}
		return groupService.getAllChildrenGroupWithJson(groupId);
	}
	
	@RequestMapping(value="/directchildrengroups/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getDirectChildrenGroup(@PathVariable("id") Integer id){
		int groupId = 0;
		if(id!=null && id.intValue()>0){
			groupId = id.intValue();
		}
		return groupService.listDirectChildrenGroupWithJson(groupId);
	}
	
}
