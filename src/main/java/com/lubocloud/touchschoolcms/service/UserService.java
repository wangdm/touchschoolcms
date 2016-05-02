package com.lubocloud.touchschoolcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.GroupDao;
import com.lubocloud.touchschoolcms.dao.RoleDao;
import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.User;

@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GroupDao groupDao;
    
	public UserService()
	{
	}
	
	public void addRole(Role r)
	{
		roleDao.save(r);
	}
	
	public void delRole(int id)
	{
		roleDao.delete(id);
	}
	
	public void findRole(int id)
	{
		roleDao.findById(id);
	}
	
	public void editRole(Role r)
	{
		roleDao.update(r);
	}
	
	public void addUser(User u)
	{
		userDao.save(u);
	}
	
	public void delUser(int id)
	{
		userDao.delete(id);
	}
	
	public void findUser(int id)
	{
		userDao.findById(id);
	}
	
	public void editUser(User u)
	{
		userDao.update(u);
	}
	
	public void addGroup(Group g)
	{
		groupDao.save(g);
	}
	
	public void delGroup(int id)
	{
		groupDao.delete(id);
	}
	
	public void findGroup(int id)
	{
		groupDao.findById(id);
	}
	
	public void editGroup(Group g)
	{
		groupDao.update(g);
	}
}
