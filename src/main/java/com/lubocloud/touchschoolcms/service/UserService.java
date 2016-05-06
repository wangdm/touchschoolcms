package com.lubocloud.touchschoolcms.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.Student;
import com.lubocloud.touchschoolcms.entity.Teacher;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
    
	public UserService()
	{
	}
	
	public void addUser(User u)
	{
		u.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		userDao.save(u);
	}
	
	public void delUser(int id)
	{
		userDao.delete(id);
	}
	
	public void editUser(User u)
	{
		userDao.update(u);
	}
	
	public User findUser(int id)
	{
		return userDao.findById(id);
	}
	
	public User findUser(String name)
	{
		return userDao.findUser(name);
	}
	
	public List<User> listUser(Page page){
		//TODO
		return null;
	}
	
	public List<User> listUser(Group group, Role role, Page page){
		//TODO
		return null;
	}
	
	public List<Student> listStudent(Group group, Page page){
		//TODO
		return null;
	}
	
	public List<Teacher> listTeacher(Group group, Page page){
		//TODO
		return null;
	}
	
	public String getUsersWithJson(int groupId, int roleId, Page page){
		//TODO
		return null;
	}
	
	public String getStudentsWithJson(int groupId, Page page){
		//TODO
		return null;
	}
	
	public String getTeachersWithJson(int groupId, Page page){
		//TODO
		return null;
	}
	
	public boolean isEnableRegister(){
		//TODO
		return true;
	}
	
	public int defaultUserRole(){
		//TODO
		return 0;
	}
}
