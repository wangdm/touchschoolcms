package com.lubocloud.touchschoolcms.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testAddRole() {
		Role r = new Role();
		r.setName("学生");
		userService.addRole(r);
	}

	@Test
	public void testDelRole() {
		userService.delRole(1);
	}

	@Test
	public void testFindRole() {
		Role r = userService.findRole(1);
		if(r!=null){
			System.out.println("id: "+r.getId()+"\tname: "+r.getName());
		}
	}

	@Test
	public void testFindAllRole() {
		List<Role> rolelist = userService.listAllRole();
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
		Role r = userService.findRole(1);
		r.setName("家长");
		userService.editRole(r);
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddGroup() {
		Group group = new Group();
		group.setName("高三");
		group.setParentGroup(userService.findGroup(11));
		userService.addGroup(group);
	}

	@Test
	public void testDelGroup() {
		userService.delGroup(0);
	}

	@Test
	public void testEditGroup() {
		Group group = userService.findGroup(3);
		group.setParentGroup(userService.findGroup(0));
		userService.editGroup(group);
	}

	@Test
	public void testFindAllGroup() {
		List<Group> grouplist = userService.listAllGroup();
		if(grouplist!=null && grouplist.size()>0){
			for(int i=0; i<grouplist.size(); i++){
				Group group = grouplist.get(i);
				System.out.println("id: "+group.getGid()+"\tname: "+group.getName());
			}
		}
	}
	
	@Test
	public void testListDirectChildrenGroup() {
		List<Group> grouplist = userService.listDirectChildrenGroup(3);
		if(grouplist!=null && grouplist.size()>0){
			for(int i=0; i<grouplist.size(); i++){
				Group group = grouplist.get(i);
				System.out.println("id: "+group.getGid()+"\tname: "+group.getName());
			}
		}
	}
	
	@Test
	public void testListAllChildrenGroupWithJson() {
		String str = userService.listAllChildrenGroupWithJson(0);
		System.out.println(str);
	}
	
	@Test
	public void testListDirectChildrenGroupWithJson() {
		String str = userService.listDirectChildrenGroupWithJson(0);
		System.out.println(str);
	}

}
