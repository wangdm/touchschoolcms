package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.PublisherDao;
import com.lubocloud.touchschoolcms.entity.Publisher;

@Service("publisherService")
@Transactional
public class PublisherService {

	@Autowired
	private PublisherDao publisherDao;
	
	public PublisherService()
	{
	}

	public void addPublisher(Publisher publisher)
	{
		publisherDao.save(publisher);
	}
	
	public void delPublisher(int publisherId)
	{
		publisherDao.delete(publisherId);
	}
	
	public void editPublisher(Publisher publisher)
	{
		publisherDao.update(publisher);
	}
	
	public Publisher findPublisher(int publisherId)
	{
		return publisherDao.findById(publisherId);
	}
	
	public List<Publisher> listAllPublisher()
	{
		return publisherDao.listAll();
	}
	
	public String listAllPublisherWithJson()
	{
		//TODO
		return null;
	}

}
