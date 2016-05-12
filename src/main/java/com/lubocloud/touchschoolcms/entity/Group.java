package com.lubocloud.touchschoolcms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 用户组的实体
 */
@Entity
@Table(name = "UserGroup")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gid", nullable=false, unique=true)
	private int gid;
	
	@Column(name="name", nullable=false, unique=true, length=20)
	private String name;
    
    @OneToOne
    @JoinColumn(name="roomId")
    private Room room;

	@ManyToOne
    @JoinColumn(name="parentId")
    private Group parentGroup;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="parentGroup")
    private List<Group> childrenGroupList;

	public Group(){

	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
    
    public Group getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Group parentGroup) {
		this.parentGroup = parentGroup;
	}

	public List<Group> getChildrenGroupList() {
		return childrenGroupList;
	}

	public void setChildrenGroupList(List<Group> childrenList) {
		this.childrenGroupList = childrenList;
	}
}