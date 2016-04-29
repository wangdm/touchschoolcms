package com.lubocloud.touchschoolcms.entity;

import java.util.List;

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

@Entity
@Table(name = "Chapter")
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=20)
	private String name;
    
    @ManyToOne
    @JoinColumn(name="parentId")
    private Chapter parentChapter;
    
    @OneToMany
    private List<Chapter> childrenChapterList;
    
    @OneToOne
    @JoinColumn(name="videoId")
    private Video video;

	public Chapter(){

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

	public Chapter getParentChapter() {
		return parentChapter;
	}

	public void setParentChapter(Chapter parentChapter) {
		this.parentChapter = parentChapter;
	}

	public List<Chapter> getChildrenChapterList() {
		return childrenChapterList;
	}

	public void setChildrenChapterList(List<Chapter> childrenChapterList) {
		this.childrenChapterList = childrenChapterList;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}