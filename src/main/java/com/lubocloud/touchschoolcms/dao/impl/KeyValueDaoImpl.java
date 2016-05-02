package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.KeyValueDao;
import com.lubocloud.touchschoolcms.entity.KeyValue;

@Repository(value = "keyvalueDao")
public class KeyValueDaoImpl extends BaseDaoImpl<KeyValue> implements KeyValueDao {
	
}
