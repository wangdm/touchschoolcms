package com.lubocloud.touchschoolcms.dao;

import java.util.List;

import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.utils.Page;

public interface RoleDao extends BaseDao<Role> {
	
	public List<Role> listRole(Page page);
}
