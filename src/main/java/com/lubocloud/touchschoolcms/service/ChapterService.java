package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.ChapterDao;
import com.lubocloud.touchschoolcms.entity.Chapter;
import com.lubocloud.touchschoolcms.entity.Textbook;

@Service("chapterService")
@Transactional
public class ChapterService {

	@Autowired
	private ChapterDao chapterDao;
	
	public ChapterService()
	{
	}
	
	public void addChapter(Chapter chapter)
	{
		chapterDao.save(chapter);
	}
	
	public void delChapter(int chapterId)
	{
		chapterDao.delete(chapterId);
	}
	
	public void editChapter(Chapter chapter)
	{
		chapterDao.update(chapter);
	}
	
	public Chapter findChapter(int chapterId)
	{
		return chapterDao.findById(chapterId);
	}
	
	public List<Chapter> listChapter(int bookId)
	{
		//TODO
		return null;
	}
	
	public List<Chapter> listChapter(Textbook book)
	{
		//TODO
		return null;
	}
	
	public String listChapterWithJson(int bookId)
	{
		//TODO
		return null;
	}
	
}
