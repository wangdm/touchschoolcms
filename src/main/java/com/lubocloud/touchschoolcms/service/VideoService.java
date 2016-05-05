package com.lubocloud.touchschoolcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.VideoDao;
import com.lubocloud.touchschoolcms.entity.Video;

@Service("videoService")
@Transactional
public class VideoService {

	
	@Autowired
	private VideoDao videoDao;
	
	public VideoService()
	{
	}
	
	public void addVideo(Video video)
	{
		videoDao.save(video);
	}
	
	public void delVideo(int videoId)
	{
		videoDao.delete(videoId);
	}
	
	public void editVideo(Video video)
	{
		videoDao.update(video);
	}
	
	public Video findVideo(int videoId)
	{
		return videoDao.findById(videoId);
	}
}
