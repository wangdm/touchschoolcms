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
@Table(name = "Course")
public class Course {

    public enum CourseStatus{
        
    }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid", nullable=false, unique=true)
	private int cid;
	
	@Column(name="title", nullable=false, unique=true, length=100)
	private String title;
    
    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name="subjectId", nullable=false)
    private Subject subject;
    
	@Column(name="create_time", nullable=false)
    private Timestamp createTime;
    
	@Column(name="update_time", nullable=false)
    private Timestamp updateTime;
    
	@Column(name="modify_time", nullable=false)
    private Timestamp modifyTime;
    
    @Column(name="status")
    private CourseStatus status;

	public Course(){

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public CourseStatus getStatus() {
		return status;
	}

	public void setStatus(CourseStatus status) {
		this.status = status;
	}
}