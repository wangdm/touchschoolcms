package com.lubocloud.touchschoolcms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import com.lubocloud.touchschoolcms.utils.Page;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:41
 */
public interface BaseDao<T> {

	/**
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * 
	 * @param id
	 */
	public T findById(Serializable id);

	/**
	 * 
	 */
	public List<T> listAll();
	/**
	 * 
	 * @param column
	 * @param value
	 */
    public List<T> findByColumn(String column, Serializable value);
    
	/**
	 * 
	 * @param c
	 * @param p
	 */
    public List<T> findByCriteria(Criteria c, Page p);

}