package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.SubjectDao;
import com.lubocloud.touchschoolcms.entity.Subject;

@Repository(value = "subjectDao")
public class SubjectDaoImpl extends BaseDaoImpl<Subject> implements SubjectDao {
	
}
