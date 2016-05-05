package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.RoleDao;
import com.lubocloud.touchschoolcms.entity.Role;

@Service("roleService")
@Transactional
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public RoleService()
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
}
