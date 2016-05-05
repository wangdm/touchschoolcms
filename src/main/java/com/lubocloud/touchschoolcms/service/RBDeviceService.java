package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.RBDeviceDao;
import com.lubocloud.touchschoolcms.entity.RBDevice;

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
	
	public void delRBDevice(int id)
	{
		rbdeviceDao.delete(id);
	}
	
	public RBDevice findRBDevice(int id)
	{
		return rbdeviceDao.findById(id);
	}
	
	public void editRBDevice(RBDevice device)
	{
		rbdeviceDao.update(device);
	}
	
	public List<RBDevice> listAllRBDevice()
	{
		return rbdeviceDao.listAll();
	}
}
