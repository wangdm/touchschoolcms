package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.RoomDao;
import com.lubocloud.touchschoolcms.entity.Room;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("roomService")
@Transactional
public class RoomService {

	@Autowired
	private RoomDao roomDao;
	
	public RoomService()
	{
	}
	
	public void addRoom(Room r)
	{
		roomDao.save(r);
	}
	
	public void delRoom(int id)
	{
		roomDao.delete(id);
	}
	
	public Room findRoom(int id)
	{
		return roomDao.findById(id);
	}
	
	public void editRoom(Room r)
	{
		roomDao.update(r);
	}
	
	public List<Room> listAllRoom()
	{
		return roomDao.listAll();
	}
	
	public List<Room> listRoom(Page page)
	{
		//TODO
		return null;
	}
	
	public String listRoomWithJson(Page page)
	{
		//TODO
		return null;
	}

}
