package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class GroupServiceTest {

	@Autowired
	GroupService groupService;

	@Test
	public void testAddGroup() {
		Group group = new Group();
		group.setName("高sifdhh");
		group.setParentGroup(groupService.findGroup(2));
		groupService.addGroup(group);
	}

	@Test
	public void testDelGroup() {
		groupService.delGroup(0);
	}

	@Test
	public void testEditGroup() {
		Group group = groupService.findGroup(9);
		group.setParentGroup(groupService.findGroup(1));
		groupService.editGroup(group);
	}

	@Test
	public void testFindAllGroup() {
		List<Group> grouplist = groupService.listAllGroup();
		if(grouplist!=null && grouplist.size()>0){
			for(int i=0; i<grouplist.size(); i++){
				Group group = grouplist.get(i);
				System.out.println("id: "+group.getGid()+"\tname: "+group.getName());
			}
		}
	}
	
	@Test
	public void testListDirectChildrenGroup() {
		List<Group> grouplist = groupService.listDirectChildrenGroup(0);
		if(grouplist!=null && grouplist.size()>0){
			for(int i=0; i<grouplist.size(); i++){
				Group group = grouplist.get(i);
				System.out.println("id: "+group.getGid()+"\tname: "+group.getName());
			}
		}
	}
	
	@Test
	public void testListAllChildrenGroupWithJson() {
		String JsonStr = groupService.getAllChildrenGroupWithJson(0);
		System.out.println(JsonStr);
	}
	
	@Test
	public void testListDirectChildrenGroupWithJson() {
		String str = groupService.listDirectChildrenGroupWithJson(0);
		System.out.println(str);
	}

}
