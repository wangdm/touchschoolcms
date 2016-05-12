package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 录播教室的实体
 */
@Entity
@Table(name = "Room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=45)
	private String name;
    
    @OneToOne
    @JoinColumn(name="deviceId")
    private RBDevice device;
    
    @OneToOne
    @JoinColumn(name="gid")
    private Group group;

	public Room(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RBDevice getDevice() {
		return device;
	}

	public void setDevice(RBDevice device) {
		this.device = device;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}