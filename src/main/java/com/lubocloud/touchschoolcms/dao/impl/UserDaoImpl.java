package com.lubocloud.touchschoolcms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:42
 */
@Repository(value = "userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public User findUser(String name) {
		Criteria c = this.getSession().createCriteria(User.class);
		c.add(Restrictions.or(Restrictions.eq("username",name),Restrictions.eq("email",name),
				 Restrictions.eq("phone",name)));
		List<User> userlist =  c.list();
		if(userlist!=null && userlist.size()>0){
			return userlist.get(0);
		}
		return null;
	}
	
	@Override
	public List<User> listUser(Group group, Role role, Page page) {
		Criteria c = this.getSession().createCriteria(User.class);
		
		if(group!=null && group.getGid()>0){
			c.add(Restrictions.eq("group.gid",group.getGid()));
		}
		
		if(role!=null && role.getId()>0){
			c.add(Restrictions.eq("group.gid",role.getId()));
		}
		
		c.setMaxResults(page.getPageSize());
		c.setFirstResult(page.getCurrentPage()*page.getPageSize());
		
		List<User> userlist = c.list();
		return userlist;
	}

	@Override
	public List<User> getUsers(int groupId, int roleId, Page page) {
		Criteria c = this.getSession().createCriteria(User.class);
		if(groupId>0){
			c.add(Restrictions.eq("group.gid",groupId));
		}
		if(roleId>0){
			c.add(Restrictions.eq("role.id", roleId));
		}
		c.setMaxResults(page.getPageSize());
		c.setFirstResult(page.getCurrentPage()*page.getPageSize());
		List<User> userlist = c.list();
		
		return userlist;
	}
}