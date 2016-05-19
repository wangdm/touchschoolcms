package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupServcie;
	@Autowired
	RoleService roleService;
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("asfdg");
		user.setPassword("123456");
		user.setGroup(groupServcie.findGroup(1));
		user.setRole(roleService.findRole(3));
		userService.addUser(user);
	}

	@Test
	public void testDelUser() {
		userService.delUser(2);;
	}

	@Test
	public void testEditUser() {
		User user = userService.findUser(15);
		if(user!=null){
			user.setUsername("fdhhgfj");
			userService.editUser(user);
		}
	}

	@Test
	public void testFindUserInt() {
		User u = userService.findUser(17);
		
		if(u !=null){
			if(u !=null){
				String str="id: "+u.getUid()+"\tusername: "+u.getUsername()+"\temail: "+u.getEmail()
				+"\tphone: "+u.getPhone()+"\tnickname: "+u.getNickname()
				+"\tregister_time: "+u.getRegisterTime();
				
				 if(u.getRole()==null){
					str+="\trole.id: "+0+"\trole.name: "+"";
				}else{
					str+="\trole.id: "+u.getRole().getId()+"\trole.name: "+u.getRole().getName();
				}
			 
			 	if(u.getGroup()==null){
					str+="\tgroup.id: "+0+"\tgroup.name: "+"";
				}else{
					str+="\tgroup.id: "+u.getGroup().getGid()+"\tgroup.name: "+u.getGroup().getName();
				}
				 	
				System.out.println(str);
			}
		}
	}
	
	
	@Test
	public void testFindUserString() {
		User u = userService.findUser("李九");
		
		if(u !=null){
			if(u !=null){
				String str="id: "+u.getUid()+"\tusername: "+u.getUsername()+"\temail: "+u.getEmail()
				+"\tphone: "+u.getPhone()+"\tnickname: "+u.getNickname()
				+"\tregister_time: "+u.getRegisterTime();
				
				 if(u.getRole()==null){
					str+="\trole.id: "+0+"\trole.name: "+"";
				}else{
					str+="\trole.id: "+u.getRole().getId()+"\trole.name: "+u.getRole().getName();
				}
			 
			 	if(u.getGroup()==null){
					str+="\tgroup.id: "+0+"\tgroup.name: "+"";
				}else{
					str+="\tgroup.id: "+u.getGroup().getGid()+"\tgroup.name: "+u.getGroup().getName();
				}
				 	
				System.out.println(str);
			}
		}
	}

	@Test
	public void testListUserPage() {
	
		Page page = new Page();
		page.setCurrentPage(0);
		List<User> userlist = userService.listUser(page);
		if(userlist !=null && userlist.size()>0){
			for(int i=0; i<userlist.size();i++){
				User u = userlist.get(i);
				if(u !=null){
					String str="id: "+u.getUid()+"\tusername: "+u.getUsername()+"\temail: "+u.getEmail()
					+"\tphone: "+u.getPhone()+"\tnickname: "+u.getNickname()
					+"\tregister_time: "+u.getRegisterTime();
					
					 if(u.getRole()==null){
						str+="\trole.id: "+0+"\trole.name: "+"";
					}else{
						str+="\trole.id: "+u.getRole().getId()+"\trole.name: "+u.getRole().getName();
					}
				 
				 	if(u.getGroup()==null){
						str+="\tgroup.id: "+0+"\tgroup.name: "+"";
					}else{
						str+="\tgroup.id: "+u.getGroup().getGid()+"\tgroup.name: "+u.getGroup().getName();
					}
					 	
					System.out.println(str);
				}
			}
		}
	}
	
	@Test
	public void testListUserGroupRolePage() {
		
		Page page = new Page();
		Group group = groupServcie.findGroup(1);
		Role role = roleService.findRole(3);
		page.setCurrentPage(0);
		List<User> userlist = userService.listUser(group, role, page);
		
		if(userlist !=null && userlist.size()>0){
			for(int i=0; i<userlist.size();i++){
				User u = userlist.get(i);
				if(u !=null){
					String str="id: "+u.getUid()+"\tusername: "+u.getUsername()+"\temail: "+u.getEmail()
					+"\tphone: "+u.getPhone()+"\tnickname: "+u.getNickname()
					+"\tregister_time: "+u.getRegisterTime();
					
					 if(u.getRole()==null){
						str+="\trole.id: "+0+"\trole.name: "+"";
					}else{
						str+="\trole.id: "+u.getRole().getId()+"\trole.name: "+u.getRole().getName();
					}
				 
				 	if(u.getGroup()==null){
						str+="\tgroup.id: "+0+"\tgroup.name: "+"";
					}else{
						str+="\tgroup.id: "+u.getGroup().getGid()+"\tgroup.name: "+u.getGroup().getName();
					}
					 	
					System.out.println(str);
				}
			}
		}
	}

	@Test
	public void testGetUsersWithJson() {
		Page page = new Page();
		page.setCurrentPage(1);
		String JsonStr = userService.getUsersWithJson(1, 3, page);
		System.out.println(JsonStr);		
	}

	@Test
	public void testEnableRegister() {
		userService.enableRegister(true);
	}

	@Test
	public void testIsEnableRegister() {
		boolean b = userService.isEnableRegister();
		System.out.println(b);
	}

	@Test
	public void testSetDefaultUserRole() {
		Role role= roleService.findRole(1);
		userService.setDefaultUserRole(role);
		System.out.println("roleId:"+role.getId()+", rolename:"+role.getName());
	}

	@Test
	public void testGetDefaultUserRole() {
		Role role = userService.getDefaultUserRole();
		System.out.println("roleId:"+role.getId()+", rolename:"+role.getName());
	}
}
