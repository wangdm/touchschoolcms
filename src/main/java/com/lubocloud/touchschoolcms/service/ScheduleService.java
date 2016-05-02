package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.ScheduleDao;
import com.lubocloud.touchschoolcms.entity.Schedule;

@Service("scheduleService")
@Transactional
public class ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	public ScheduleService()
	{
		//roleDao  = new RoleDaoImpl();
	}
	
	/*
	 *  Schedule
	 */
	public void addSchedule(Schedule s)
	{
		scheduleDao.save(s);
	}
	
	public void delSchedule(int scheduleId)
	{
		scheduleDao.delete(scheduleId);
	}
	
	public void editSchedule(Schedule s)
	{
		scheduleDao.update(s);
	}
	
	public Schedule findSchedule(int scheduleId)
	{
		return scheduleDao.findById(scheduleId);
	}
	
	public List<Schedule> queryScheduleByTeacher(int uid)
	{
		return scheduleDao.findByColumn("Teacher.uid", uid);
	}
	
	public List<Schedule> queryScheduleByGroup(int gid)
	{
		return scheduleDao.findByColumn("Group.id", gid);
	}
	
	public List<Schedule> queryScheduleByRoom(int roomId)
	{
		return scheduleDao.findByColumn("Room.id", roomId);
	}
}
