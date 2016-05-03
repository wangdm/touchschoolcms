package com.lubocloud.touchschoolcms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.BaseDao;
import com.lubocloud.touchschoolcms.utils.Page;

/**
 * @author wangdm
 * @version 1.0
 * @created 15-4��-2016 18:48:41
 */
@Repository
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;
	
	public BaseDaoImpl(){
		String fullClassName = this.getClass().getName();
		String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1);
		if(!"BaseDaoImpl".equals(className))
		{
			//System.out.println("this class name is "+ className);
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
	        clazz = (Class<T>) type.getActualTypeArguments()[0];
		}
	}
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		if(this.sessionFactory==null)
		{
			System.out.println("sessionFactory is null");
			return null;
		}
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 
	 * @param id
	 */
	@Override
	public void delete(Serializable id){
		this.getSession().delete(this.findById(id));
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public T findById(Serializable id){
		return (T)this.getSession().get(this.clazz, id);
	}

	/**
	 * 
	 * @param entity
	 */
	@Override
	public void save(T entity){
		Session s = this.getSession();
		if(s==null){
			System.out.println("Session is null");
		}else{
			s.save(entity);
		}
	}

	/**
	 * 
	 * @param entity
	 */
	@Override
	public void update(T entity){
		this.getSession().update(entity);
	}

	@Override
	public List<T> listAll() {
		Session s = this.getSession();
		if(s!=null){
			Criteria c = s.createCriteria(this.clazz);
			return c.list();
		}
		return null;
	}

	/**
	 * 
	 * @param column
	 * @param value
	 */
	@Override
	public List<T> findByColumn(String column, Serializable value) {
		Criteria c = this.getSession().createCriteria(this.clazz);
		if(value==null){
			c.add(Restrictions.isNull(column));
		}else{
			c.add(Restrictions.eq(column,value));
		}
		return c.list();
	}

	@Override
	public List<T> findByCriteria(Criteria c, Page p) {
		return null;
	}
}