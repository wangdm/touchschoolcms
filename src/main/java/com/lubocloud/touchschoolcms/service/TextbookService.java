package com.lubocloud.touchschoolcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.ChapterDao;
import com.lubocloud.touchschoolcms.dao.PublisherDao;
import com.lubocloud.touchschoolcms.dao.TextbookDao;
import com.lubocloud.touchschoolcms.entity.Chapter;
import com.lubocloud.touchschoolcms.entity.Publisher;
import com.lubocloud.touchschoolcms.entity.Textbook;

@Service("textbookService")
@Transactional
public class TextbookService {

	@Autowired
	private TextbookDao textbookDao;

	@Autowired
	private PublisherDao publisherDao;
	
	@Autowired
	private ChapterDao chapterDao;
	
	public TextbookService()
	{
	}
	/*
	 *  Textbook
	 */
	
	public void addTextbook(Textbook book)
	{
		textbookDao.save(book);
	}
	
	public void delTextbook(int bookId)
	{
		textbookDao.delete(bookId);
	}
	
	public void editTextbook(Textbook book)
	{
		textbookDao.update(book);
	}
	
	public Textbook findTextbook(int bookId)
	{
		return textbookDao.findById(bookId);
	}

	/*
	 *  Chapter
	 */
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
	
	/*
	 *  Publisher
	 */
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

}
