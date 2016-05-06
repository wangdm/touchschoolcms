package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.RBDeviceDao;
import com.lubocloud.touchschoolcms.entity.RBDevice;
import com.lubocloud.touchschoolcms.entity.Room;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("rbdeviceService")
@Transactional
public class RBDeviceService {

	@Autowired
	private RBDeviceDao rbdeviceDao;

	public RBDeviceService()
	{
	}
	
	public void addRBDevice(RBDevice device)
	{
		rbdeviceDao.save(device);
	}
	
	public void editRBDevice(RBDevice device)
	{
		rbdeviceDao.update(device);
	}
	
	public void delRBDevice(int id)
	{
		rbdeviceDao.delete(id);
	}
	
	public RBDevice findRBDevice(int id)
	{
		return rbdeviceDao.findById(id);
	}
	
	public RBDevice findRBDevice(Room room)
	{
		//TODO
		return null;
	}
	
	public List<RBDevice> listAllRBDevice()
	{
		return rbdeviceDao.listAll();
	}
	
	public List<RBDevice> listRBDevice(Page page)
	{
		//TODO
		return null;
	}
	
	public String listRBDeviceWithJson(Page page)
	{
		//TODO
		return null;
	}
}
