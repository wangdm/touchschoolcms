package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 老师实体
 */
@Entity
@Table(name = "Teacher")
public class Teacher extends User{
	
	@Column(name="fullname", nullable=false, unique=true, length=45)
	private String fullname;

	public Teacher(){

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}