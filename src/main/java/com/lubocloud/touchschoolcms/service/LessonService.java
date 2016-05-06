package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.LessonDao;
import com.lubocloud.touchschoolcms.entity.Lesson;

@Service("lessonService")
@Transactional
public class LessonService {
	
	@Autowired
	private LessonDao lessonDao;
	
	public LessonService()
	{
	}
	
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

	public List<Lesson> listAllLesson()
	{
		return lessonDao.listAll();
	}
	
	public String listLessonWithJson()
	{
		//TODO
		return null;
	}
}
