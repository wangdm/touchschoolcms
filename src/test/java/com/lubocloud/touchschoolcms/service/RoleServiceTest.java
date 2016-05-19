package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.utils.Page;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class RoleServiceTest {

	@Autowired
	RoleService roleService;
	
	@Test
	public void testAddRole() {
		Role r = new Role();
		r.setName("老师10");
		roleService.addRole(r);
	}

	@Test
	public void testDelRole() {
		roleService.delRole(0);
	}

	@Test
	public void testFindRole() {
		Role r = roleService.findRole(3);
		if(r !=null){
			System.out.println("id:"+r.getId()+"\tname:"+r.getName());
		}
	}

	@Test
	public void testEditRole() {
		Role r = roleService.findRole(3);
		if(r !=null){
			r.setName("深圳");
			roleService.editRole(r);
		}
	}

	@Test
	public void testListAllRole() {
		List<Role> rolelist = roleService.listAllRole();
		if(rolelist !=null && rolelist.size()>0){
			for(int i=0;i<rolelist.size();i++){
				Role r = rolelist.get(i);
				System.out.println("id:"+r.getId()+"\tname:"+r.getName());
			}
		}
	}

	@Test
	public void testListRole() {
		Page page = new Page();
		page.setCurrentPage(0);
		List<Role> rolelist = roleService.listRole(page);
		if(rolelist.size()>0 && rolelist !=null){
			for(int i=0; i<rolelist.size();i++){
				Role r = rolelist.get(i);
				if(r !=null){
					System.out.println("id:"+r.getId()+"\tname:"+r.getName());
				}
			}
		}
	}

	@Test
	public void testListRoleWithJson() {
		Page page = new Page();
		page.setCurrentPage(0);
		String JsonStr = roleService.listRoleWithJson(page);
		System.out.println(JsonStr);
	}

}
