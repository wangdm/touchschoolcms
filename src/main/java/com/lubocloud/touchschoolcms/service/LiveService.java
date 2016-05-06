package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.LiveDao;
import com.lubocloud.touchschoolcms.entity.Course;
import com.lubocloud.touchschoolcms.entity.Live;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("liveService")
@Transactional
public class LiveService {
	
	@Autowired
	private LiveDao liveDao;
	
	public LiveService()
	{
	}
	
	public void addLive(Live live)
	{
		liveDao.save(live);
	}
	
	public void delLive(int liveId)
	{
		liveDao.delete(liveId);
	}
	
	public void editLive(Live live)
	{
		liveDao.update(live);
	}
	
	public Live findLive(int liveId)
	{
		return liveDao.findById(liveId);
	}
	
	public List<Live> listLive(Course course)
	{
		//TODO
		return null;
	}
	
	public List<Live> listLive(User user, Page page)
	{
		//TODO
		return null;
	}
	
	public String getLivesWithJsonByCourse(int cid, Page page)
	{
		//TODO
		return null;
	}
	
	public String getLivesWithJsonByUser(int uid, Page page)
	{
		//TODO
		return null;
	}
}
