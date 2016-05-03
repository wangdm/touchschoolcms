package com.lubocloud.touchschoolcms.dao;

import com.lubocloud.touchschoolcms.entity.User;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:42
 */
public interface UserDao extends BaseDao<User>{
	
	public User findUserByName(String name);
}