package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.CourseDao;
import com.lubocloud.touchschoolcms.entity.Course;

@Repository(value = "courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {
	
}
