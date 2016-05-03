package com.lubocloud.touchschoolcms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vid", nullable=false, unique=true)
	private int vid;
	
	@Column(name="title", nullable=false, unique=true, length=100)
	private String title;
    
    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name="subjectId", nullable=false)
    private Subject subject;
    
	@Column(name="create_time", nullable=false)
    private Timestamp createTime;

	public Video(){

	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}