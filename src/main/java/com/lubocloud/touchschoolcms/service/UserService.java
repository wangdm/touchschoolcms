package com.lubocloud.touchschoolcms.service;

import java.sql.Timestamp;
import java.util.List;

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
	
	public Role findRole(int id)
	{
		return roleDao.findById(id);
	}
	
	public void editRole(Role r)
	{
		roleDao.update(r);
	}
	
	public List<Role> listAllRole()
	{
		return roleDao.listAll();
	}
	
	public void addGroup(Group g)
	{
		groupDao.save(g);
	}
	
	public void delGroup(int id)
	{
		groupDao.delete(id);
	}
	
	public void editGroup(Group g)
	{
		groupDao.update(g);
	}
	
	public Group findGroup(int id)
	{
		return groupDao.findById(id);
	}
	
	public List<Group> listAllGroup()
	{
		return groupDao.listAll();
	}
	
	public List<Group> listDirectChildrenGroup(int id)
	{
		if(id<=0){
			return groupDao.findByColumn("parentGroup", null);
		}else{
			return groupDao.findByColumn("parentGroup.gid", id);
		}
	}
	
	public String listAllChildrenGroupWithJson(int id)
	{
		String jsonStr = null;
		return jsonStr;
	}
	
	public String listDirectChildrenGroupWithJson(int id)
	{
		String jsonStr = null;
		List<Group> grouplist = null;
		
		if(id>0){
			Group group = groupDao.findById(id);
			if(group!=null)
			{
				jsonStr = "{\"name\": \""+group.getName()+"\", \"id\": "+group.getGid();
				grouplist = groupDao.findByColumn("parentGroup.gid", id);
			}else{
				return null;
			}
		}else{
			jsonStr = "{\"name\": \"在线学习平台\", \"id\": 0";
			grouplist = groupDao.findByColumn("parentGroup", null);
		}
		if(grouplist!=null && grouplist.size()>0){
        	jsonStr += ", \"children\":[";
        	for(int i=0; i<grouplist.size(); i++){
        		Group childgroup = grouplist.get(i);
        		jsonStr += "{\"name\":\""+childgroup.getName()+"\",\"id\":"+childgroup.getGid();
        		if(i==grouplist.size()-1){
        			jsonStr += "}";
        		}else{
        			jsonStr += "},";
        		}
        	}
			jsonStr += "]";
        }
		jsonStr += "}";
		return jsonStr;
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
