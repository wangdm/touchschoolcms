package com.lubocloud.touchschoolcms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Subject;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class SubjectServiceTest {

	@Autowired
	SubjectService subjectService;
	@Test
	public void testAddSubject() {
		Subject subject = new Subject();
		subject.setName("fdhgg学");
		subjectService.addSubject(subject);
	}

	@Test
	public void testDelSubject() {
		subjectService.delSubject(1);
	}

	@Test
	public void testEditSubject() {
		Subject subject = subjectService.findSubject(0);
		if(subject!=null){
			subject.setName("生物学");
			subjectService.editSubject(subject);
		}
	}

	@Test
	public void testFindSubject() {
		Subject subject = subjectService.findSubject(1);
		if(subject!=null){
			System.out.println("id:"+subject.getId()+"\tname"+subject.getName());
		}
			
	}

	@Test
	public void testListAllSubject() {
		List<Subject> subjectlist = subjectService.listAllSubject();
		if(subjectlist.size()>0 && subjectlist!=null){
			for(int i=0; i<subjectlist.size();i++){
				Subject subject = subjectlist.get(i);
						if(subject!=null){
							System.out.println("id:"+subject.getId()+"\tname"+subject.getName());
						}
			}
		}
	}

	@Test
	public void testListSubjectWithJson() {
		String Json = subjectService.listSubjectWithJson();
		System.out.println(Json);
	}

}
