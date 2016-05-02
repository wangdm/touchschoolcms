package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.CategoryDao;
import com.lubocloud.touchschoolcms.entity.Category;

@Repository(value = "categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	
}
