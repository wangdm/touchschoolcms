package com.lubocloud.touchschoolcms.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.SubjectDao;
import com.lubocloud.touchschoolcms.entity.Subject;

@Service("subjectService")
@Transactional
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	public SubjectService()
	{
	}
	
	public void addSubject(Subject subject)
	{
		subjectDao.save(subject);
	}
	
	public void delSubject(int subjectId)
	{
		subjectDao.delete(subjectId);
	}
	
	public void editSubject(Subject subject)
	{
		subjectDao.update(subject);
	}
	
	public Subject findSubject(int subjectId)
	{
		return subjectDao.findById(subjectId);
	}
	
	public List<Subject> listAllSubject()
	{
		return subjectDao.listAll();
	}
	
	public String listSubjectWithJson()
	{
		String JsonStr=null;
		List<Subject> subjectlist=new ArrayList<Subject>();
		subjectlist=subjectDao.listAll();
		JsonStr="\"list\":[";
		if(subjectlist.size()>0||subjectlist!=null){
			for(int i=0;i<subjectlist.size();i++){
				Subject sub=subjectlist.get(i);
				if(sub==null){
					return null;
				}else{
					JsonStr+="{\"name\":\""+sub.getName()+"\",\"id\":"+sub.getId();
				}
				
				if(i==subjectlist.size()-1){
					JsonStr += "}";
				}else{
					JsonStr += "},";
				}
			}
			JsonStr += "]";
		}

		return JsonStr;
	}
	
}
