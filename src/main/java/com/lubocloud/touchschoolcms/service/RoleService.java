package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.RoleDao;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.utils.Page;

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
	
	public List<Role> listRole(Page page)
	{
		List<Role> rolelist = roleDao.listRole(page);
		return rolelist;
	}
	
	public String listRoleWithJson(Page page)
	{
		String JsonStr = null;
		List<Role> rolelist = roleDao.listRole(page);
		JsonStr ="[";
		if(rolelist.size()>0 && rolelist!=null){
			for(int i=0;i<rolelist.size();i++){
				Role r=rolelist.get(i);
				if(r==null){
					return null;
				}else{
					JsonStr+="{\"name\":\""+r.getName()+"\",\"id\":"+r.getId();
				}
				
				if(i==rolelist.size()-1){
					JsonStr += "}";
				}else{
					JsonStr += "},";
				}
			}
			JsonStr += "]";
		}
		return JsonStr;
	}
}
