package com.lubocloud.touchschoolcms.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.KeyValueDao;
import com.lubocloud.touchschoolcms.dao.RoleDao;
import com.lubocloud.touchschoolcms.dao.UserDao;
import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.KeyValue;
import com.lubocloud.touchschoolcms.entity.Role;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private KeyValueDao keyvalueDao;
    
	public UserService()
	{
	}
	
	private String userListToJson(List<User> userlist)
	{
		String JsonStr = null;
		for(int i=0;i<userlist.size();i++){
			User u=userlist.get(i);
			if(u==null){
				return null;
			}else{
				if(u !=null){
					
					JsonStr="[{\"username\":\""+u.getUsername()+"\",\"uid\":\""+u.getUid()+"\","
							+ "\"email\":\""+u.getEmail()+"\",\"phone\":\""+u.getPhone()+"\","
							+ "\"nickname\":\""+u.getNickname()+"\",\"registerTime\":\""+u.getRegisterTime()+"\",";
										 
					if(u.getRole()==null){
						JsonStr+="\"role\":{\"id\":\""+0+"\","+ "\"name\":\""+""+"\"},";
					}else {
						JsonStr+="\"role\":{\"id\":\""+u.getRole().getId()+"\","+ "\"name\":\""+u.getRole().getName()+"\"},";
					}
										
					if(u.getGroup()==null){
						JsonStr+="\"group\":{\"id\":\""+0+"\","+ "\"name\":\""+""+"\"}";
					}else{
						JsonStr+="\"group\":{\"id\":\""+u.getGroup().getGid()+"\","+ "\"name\":\""+u.getGroup().getName()+"\"}";
					}
				}
			}
			
			if(i==userlist.size()-1){
				JsonStr += "}";
			}else{
				JsonStr += "},";
			}
		}
		JsonStr += "]";
		return JsonStr;
	}
	
	public void addUser(User u)
	{
		u.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		if(u.getGroup()!=null && u.getGroup().getGid()<=0){
			u.setGroup(null);
		}
		if(u.getRole()!=null && u.getRole().getId()<=0){
			u.setRole(this.getDefaultUserRole());
		}
		userDao.save(u);
	}
	
	public void delUser(int id)
	{
		userDao.delete(id);
	}
	
	public void editUser(User u)
	{
		userDao.update(u);
	}
	
	public User findUser(int id)
	{
		return userDao.findById(id);
	}
	
	public User findUser(String name)
	{
		return userDao.findUser(name);
	}
	
	public List<User> listUser(Page page){
		List<User> userlist = userDao.listUser(null, null, page);
		return userlist;
	}
	
	
	public List<User> listUser(Group group, Role role, Page page){
		List<User> userlist = userDao.listUser(group, role, page);
		return userlist;
	}
	
	public String getUsersWithJson(Page page){
		String JsonStr = null;
		List<User> userlist = userDao.listUser(null, null, page);
		if(userlist.size()>0||userlist!=null){
			JsonStr = this.userListToJson(userlist);
		}
		return JsonStr;
	}
	
	public String getUsersWithJson(int groupId, int roleId, Page page){
		String JsonStr = null;
		List<User> userlist = userDao.getUsers(groupId, roleId, page);
		if(userlist.size()>0||userlist!=null){
			JsonStr = this.userListToJson(userlist);
		}
		return JsonStr;
	}

	public void enableRegister(boolean b){
		KeyValue kv = null;
		List<KeyValue> list = keyvalueDao.findByColumn("key", KeyValue.enableRegister);
		if(list!=null && list.size()>0){
			kv = list.get(0);
			kv.setValue(String.valueOf(b));
			keyvalueDao.update(kv);
		}else{
			kv = new KeyValue();
			kv.setKey(KeyValue.enableRegister);
			kv.setValue(String.valueOf(b));
			keyvalueDao.save(kv);
		}
	}
	
	public boolean isEnableRegister(){
		List<KeyValue> list = keyvalueDao.findByColumn("key", KeyValue.enableRegister);
		if(list!=null && list.size()>0){
			return Boolean.parseBoolean(list.get(0).getValue());
		}else{
			return false;
		}
	}
	
	public Role getDefaultUserRole(){
		List<KeyValue> list = keyvalueDao.findByColumn("key", KeyValue.defaultUserRole);
		Role role = null;
		if(list!=null && list.size()>0){
			int roleId = Integer.parseInt(list.get(0).getValue());
			role = roleDao.findById(roleId);
		}
		return role;
	}
	
	public void setDefaultUserRole(Role role){
		KeyValue kv = null;
		List<KeyValue> list = keyvalueDao.findByColumn("key", KeyValue.defaultUserRole);
		if(list!=null && list.size()>0){
			kv = list.get(0);
			kv.setValue(String.valueOf(role.getId()));
			keyvalueDao.update(kv);
		}else{
			kv = new KeyValue();
			kv.setKey(KeyValue.defaultUserRole);
			kv.setValue(String.valueOf(role.getId()));
			keyvalueDao.save(kv);
		}
	}
}
