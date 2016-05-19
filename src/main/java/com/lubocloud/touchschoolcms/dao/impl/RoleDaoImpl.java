package com.lubocloud.touchschoolcms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.RoleDao;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.utils.Page;

@SuppressWarnings("unchecked")
@Repository(value = "roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> listRole(Page page) {
		Criteria c = this.getSession().createCriteria(Role.class);
		c.setMaxResults(page.getPageSize());
		c.setFirstResult(page.getCurrentPage()*page.getPageSize());
		List<Role> rolelist = c.list();
		return rolelist;
	}
	
}
