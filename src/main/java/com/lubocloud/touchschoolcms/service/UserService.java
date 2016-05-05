package com.lubocloud.touchschoolcms.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.User;

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
	
	public User findUser(int id)
	{
		return userDao.findById(id);
	}
	
	public User findUserByName(String name)
	{
		return userDao.findUserByName(name);
	}
	
	public void editUser(User u)
	{
		userDao.update(u);
	}
}
