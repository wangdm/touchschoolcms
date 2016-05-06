package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.VideoDao;
import com.lubocloud.touchschoolcms.entity.Category;
import com.lubocloud.touchschoolcms.entity.Chapter;
import com.lubocloud.touchschoolcms.entity.Course;
import com.lubocloud.touchschoolcms.entity.Textbook;
import com.lubocloud.touchschoolcms.entity.User;
import com.lubocloud.touchschoolcms.entity.Video;
import com.lubocloud.touchschoolcms.utils.Page;

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
	
	public Video findVideo(Chapter chapter)
	{
		//TODO
		return null;
	}
	
	public List<Video> listVideo(Category category, String title, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Video> listVideo(Course course)
	{
		//TODO
		return null;
	}
	
	public List<Video> listVideo(User user, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Video> listVideo(Textbook book, Page page)
	{
		//TODO
		return null;
	}
	
	public String getVideosWithJson(int catId, String title, Page page)
	{
		//TODO
		return null;
	}
	
	public String getVideosWithJsonByCourse(int cid, Page page)
	{
		//TODO
		return null;
	}
	
	public String getVideosWithJsonByUser(int uid, Page page)
	{
		//TODO
		return null;
	}
	
	public String getVideosWithJsonByTextbook(int textbookId, Page page)
	{
		//TODO
		return null;
	}
}
