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

/*
 * 直播课程的实体
 */
@Entity
@Table(name = "Live")
public class Live {
	
	public enum LiveStatus{
		Verifying,Upcoming,Living,End,Blocked
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private String id;
	
	@Column(name="title", nullable=false, unique=true, length=60)
	private String title;

	@Column(name="starttime", nullable=false)
	private Timestamp startTime;

	@Column(name="endtime", nullable=false)
	private Timestamp endTime;

	@Column(name="status", nullable=false)
	private LiveStatus status;
	
    @ManyToOne
    @JoinColumn(name="cid")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;

	public Live(){

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public LiveStatus getStatus() {
		return status;
	}

	public void setStatus(LiveStatus status) {
		this.status = status;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}