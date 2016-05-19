package com.lubocloud.touchschoolcms.service;

import java.util.ArrayList;
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
		String JsonStr = null;
		List<Lesson> lessonlist = new ArrayList<Lesson>();
		lessonlist = lessonDao.listAll();
		JsonStr ="\"List\"[";
		if(lessonlist.size()>0 && lessonlist!=null){
			for(int i =0; i<lessonlist.size();i++){
				Lesson lesson = lessonlist.get(i);
				if(lesson!=null){
					JsonStr +="{\"name\":\""+lesson.getName()+"\",\"id\":"+lesson.getId();
				}else{
					return null;
				}
				if(i==lessonlist.size()-1){
					JsonStr +="}";
				}
				JsonStr +="},";
			}
			JsonStr +="]";
		}
		return JsonStr;
	}
}
