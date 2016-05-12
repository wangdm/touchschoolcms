package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 学生实体
 */
@Entity
@Table(name = "Student")
public class Student extends User{
	
	@Column(name="fullname",  length=45)
	private String fullname;

	public Student(){

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}