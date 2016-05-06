package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class RoleServiceTest {

	@Autowired
	RoleService roleService;
	
	@Test
	public void testAddRole() {
		Role r = new Role();
		r.setName("学生");
		roleService.addRole(r);
	}

	@Test
	public void testDelRole() {
		roleService.delRole(1);
	}

	@Test
	public void testFindRole() {
		Role r = roleService.findRole(1);
		if(r!=null){
			System.out.println("id: "+r.getId()+"\tname: "+r.getName());
		}
	}

	@Test
	public void testFindAllRole() {
		List<Role> rolelist = roleService.listAllRole();
		if(rolelist!=null){
			for(int i=0; i<rolelist.size(); i++)
			{
				Role r = rolelist.get(i);
				System.out.println("id: "+r.getId()+"\tname: "+r.getName());
			}
		}
	}

	@Test
	public void testEditRole() {
		Role r = roleService.findRole(1);
		r.setName("家长");
		roleService.editRole(r);
	}
}
