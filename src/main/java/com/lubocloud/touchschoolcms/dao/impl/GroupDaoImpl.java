package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.GroupDao;
import com.lubocloud.touchschoolcms.entity.Group;

@Repository(value = "groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao {
	
}
