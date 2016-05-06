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
		group.setName("高三");
		group.setParentGroup(groupService.findGroup(11));
		groupService.addGroup(group);
	}

	@Test
	public void testDelGroup() {
		groupService.delGroup(0);
	}

	@Test
	public void testEditGroup() {
		Group group = groupService.findGroup(3);
		group.setParentGroup(groupService.findGroup(0));
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
		List<Group> grouplist = groupService.listDirectChildrenGroup(3);
		if(grouplist!=null && grouplist.size()>0){
			for(int i=0; i<grouplist.size(); i++){
				Group group = grouplist.get(i);
				System.out.println("id: "+group.getGid()+"\tname: "+group.getName());
			}
		}
	}
	
	@Test
	public void testListAllChildrenGroupWithJson() {
		String str = groupService.listAllChildrenGroupWithJson(0);
		System.out.println(str);
	}
	
	@Test
	public void testListDirectChildrenGroupWithJson() {
		String str = groupService.listDirectChildrenGroupWithJson(0);
		System.out.println(str);
	}

}
