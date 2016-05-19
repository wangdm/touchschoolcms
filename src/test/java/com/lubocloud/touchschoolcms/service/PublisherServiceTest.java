package com.lubocloud.touchschoolcms.service;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lubocloud.touchschoolcms.entity.Publisher;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-*.xml")
public class PublisherServiceTest {

	@Autowired
	PublisherService publisherService;
	
	@Test
	public void testAddPublisher() {
		Publisher publisher = new Publisher();
		publisher.setName("张三");
		publisherService.addPublisher(publisher);
	}

	@Test
	public void testDelPublisher() {
		publisherService.delPublisher(23);
	}

	@Test
	public void testEditPublisher() {
		Publisher publisher = publisherService.findPublisher(22);
		if(publisher!=null){
			publisher.setName("李四");
			publisherService.editPublisher(publisher);
		}
	}

	@Test
	public void testFindPublisher() {
		Publisher publisher = publisherService.findPublisher(0);
		if(publisher!=null){
			System.out.println("id:"+publisher.getId()+"\tname"+publisher.getName());
		}
	}

	@Test
	public void testListAllPublisher() {
		List<Publisher> publiherlist = publisherService.listAllPublisher();
		if(publiherlist!=null&&publiherlist.size()>0){
			for(int i=0; i<publiherlist.size();i++){
				Publisher publisher = publiherlist.get(i);
				System.out.println("id:"+publisher.getId()+"\tname:"+publisher.getName());
			}
		}
	}

	@Test
	public void testListAllPublisherWithJson() {
		String Json = publisherService.listAllPublisherWithJson();
		System.out.println(Json);
	}

}
