package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.LiveDao;
import com.lubocloud.touchschoolcms.entity.Live;

@Repository(value = "liveDao")
public class LiveDaoImpl extends BaseDaoImpl<Live> implements LiveDao {
	
}
