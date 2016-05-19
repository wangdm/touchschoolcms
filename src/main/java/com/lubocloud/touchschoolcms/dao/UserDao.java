package com.lubocloud.touchschoolcms.dao;

import java.util.List;

import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:42
 */
public interface UserDao extends BaseDao<User>{
	
	public User findUser(String name);
	
	public List<User> listUser(Group group, Role role, Page page);
	
	public List<User> getUsers(int groupId, int roleId, Page page);
}