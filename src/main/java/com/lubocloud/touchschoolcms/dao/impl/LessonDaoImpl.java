package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.LessonDao;
import com.lubocloud.touchschoolcms.entity.Lesson;

@Repository(value = "lessonDao")
public class LessonDaoImpl extends BaseDaoImpl<Lesson> implements LessonDao {
	
}
