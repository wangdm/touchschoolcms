package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.TextbookDao;
import com.lubocloud.touchschoolcms.entity.Publisher;
import com.lubocloud.touchschoolcms.entity.Subject;
import com.lubocloud.touchschoolcms.entity.Textbook;
import com.lubocloud.touchschoolcms.utils.Page;

@Service("textbookService")
@Transactional
public class TextbookService {

	@Autowired
	private TextbookDao textbookDao;
	
	public TextbookService()
	{
	}
	
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
	
	public List<Textbook> listTextbook(Page page)
	{
		//TODO
		return null;
	}
	
	public List<Textbook> listTextbook(Publisher publisher, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Textbook> listTextbook(Subject subject, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Textbook> listTextbook(Publisher publisher, Subject subject, Page page)
	{
		//TODO
		return null;
	}
	
	public List<Textbook> listTextbook(int publisherId, int subjectId, Page page)
	{
		//TODO
		return null;
	}

	public String listTextbookWithJson(int publisherId, int subjectId, Page page)
	{
		//TODO
		return null;
	}
}
