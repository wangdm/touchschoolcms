package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.ScheduleDao;
import com.lubocloud.touchschoolcms.entity.Group;
import com.lubocloud.touchschoolcms.entity.Room;
import com.lubocloud.touchschoolcms.entity.Schedule;
import com.lubocloud.touchschoolcms.entity.Schedule.Week;
import com.lubocloud.touchschoolcms.entity.Teacher;

@Service("scheduleService")
@Transactional
public class ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	public ScheduleService()
	{
	}
	
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
	
	public List<Schedule> querySchedule(Teacher teacher)
	{
		return scheduleDao.findByColumn("teacher.uid", teacher.getUid());
	}
	
	public List<Schedule> querySchedule(Group group)
	{
		return scheduleDao.findByColumn("group.gid", group.getGid());
	}
	
	public List<Schedule> queryScheduleByRoom(Room room)
	{
		return scheduleDao.findByColumn("room.id", room.getId());
	}
	
	public List<Schedule> queryScheduleByTeacher(int uid)
	{
		return scheduleDao.findByColumn("teacher.uid", uid);
	}
	
	public List<Schedule> queryScheduleByGroup(int gid)
	{
		return scheduleDao.findByColumn("group.id", gid);
	}
	
	public List<Schedule> queryScheduleByRoom(int roomId)
	{
		return scheduleDao.findByColumn("room.id", roomId);
	}
	
	public String getTeacherScheduleWithJson(int uid)
	{
		//TODO
		return null;
	}
	
	public String getGroupScheduleWithJson(int gid)
	{
		//TODO
		return null;
	}
	
	public String getRoomScheduleWithJson(int roomId)
	{
		//TODO
		return null;
	}
	
	public String getRoomScheduleOnDayWithJson(int roomId, Week week)
	{
		//TODO
		return null;
	}
	
}
