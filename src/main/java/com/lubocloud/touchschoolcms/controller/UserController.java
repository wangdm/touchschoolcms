package com.lubocloud.touchschoolcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/adduser")
	public String addRole()
	{
		Role role = new Role();
		role.setName("student");
		userService.addRole(role);
		return "addrole";
	}
}
