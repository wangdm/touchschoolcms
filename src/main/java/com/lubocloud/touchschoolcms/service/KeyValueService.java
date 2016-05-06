package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.KeyValueDao;
import com.lubocloud.touchschoolcms.entity.KeyValue;

@Service("keyvalueService")
@Transactional
public class KeyValueService {

	@Autowired
	private KeyValueDao keyvalueDao;

	public KeyValueService()
	{
	}
	
	public void addKeyValue(KeyValue kv)
	{
		keyvalueDao.save(kv);
	}
	
	public void delKeyValue(int id)
	{
		keyvalueDao.delete(id);
	}
	
	public void editKeyValue(KeyValue kv)
	{
		keyvalueDao.update(kv);
	}
	
	public KeyValue findKeyValue(int id)
	{
		return keyvalueDao.findById(id);
	}
	
	public KeyValue findKeyValue(String key)
	{
		KeyValue kv = null;
		List<KeyValue> list = keyvalueDao.findByColumn("key", key);
		if(list!=null && list.size()>0){
			kv = list.get(0);
		}
		return kv;
	}
	
	public List<KeyValue> listAllKeyValue()
	{
		return keyvalueDao.listAll();
	}
}
