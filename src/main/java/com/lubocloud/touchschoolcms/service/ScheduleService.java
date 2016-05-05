package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.LessonDao;
import com.lubocloud.touchschoolcms.dao.ScheduleDao;
import com.lubocloud.touchschoolcms.dao.SubjectDao;
import com.lubocloud.touchschoolcms.entity.Lesson;
import com.lubocloud.touchschoolcms.entity.Schedule;
import com.lubocloud.touchschoolcms.entity.Subject;

@Service("scheduleService")
@Transactional
public class ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private LessonDao lessonDao;
	
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
	
	/*
	 *  Subject
	 */
	public void addSubject(Subject subject)
	{
		subjectDao.save(subject);
	}
	
	public void delSubject(int subjectId)
	{
		subjectDao.delete(subjectId);
	}
	
	public void editSubject(Subject subject)
	{
		subjectDao.update(subject);
	}
	
	public Subject findSubject(int subjectId)
	{
		return subjectDao.findById(subjectId);
	}
	
	/*
	 *  Lesson
	 */
	public void addLesson(Lesson lesson)
	{
		lessonDao.save(lesson);
	}
	
	public void delLesson(int lessonId)
	{
		lessonDao.delete(lessonId);
	}
	
	public void editLesson(Lesson lesson)
	{
		lessonDao.update(lesson);
	}
	
	public Lesson findLesson(int lessonId)
	{
		return lessonDao.findById(lessonId);
	}

	
}
