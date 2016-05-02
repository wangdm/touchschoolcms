package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.StudentDao;
import com.lubocloud.touchschoolcms.entity.Student;

@Repository(value = "studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	
}
