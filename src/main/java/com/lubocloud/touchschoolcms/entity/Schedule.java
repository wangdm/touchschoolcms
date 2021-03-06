package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * 课程表实体
 */
@Entity
@Table(name = "Schedule")
public class Schedule {
	
	public enum Week{Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;

	@Column(name="week", nullable=false)
	private Week week;
	
    @ManyToOne
    @JoinColumn(name="lessonId")
    private Lesson lesson;
    
    @ManyToOne
    @JoinColumn(name="subjectId")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name="groupId")
    private Group group;
    
    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;
    
    @ManyToOne
    @JoinColumn(name="teacherId")
    private Teacher teacher;

	public Schedule(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}