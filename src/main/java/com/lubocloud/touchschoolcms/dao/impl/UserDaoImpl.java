package com.lubocloud.touchschoolcms.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.User;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:42
 */
@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public User findUserByName(String name) {
		Criteria c = this.getSession().createCriteria(User.class);
		c.add(Restrictions.or(Restrictions.eq("username",name),Restrictions.eq("email",name),Restrictions.eq("phone",name)));
		return null;
	}

}