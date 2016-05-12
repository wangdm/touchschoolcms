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
 * 课本章节的实体
 */
@Entity
@Table(name = "Chapter")
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="title", nullable=false, unique=true, length=60)
	private String title;
	
    @ManyToOne
    @JoinColumn(name="textbookId", nullable=false)
    private Textbook textbook;
    
    @ManyToOne
    @JoinColumn(name="parentId")
    private Chapter parentChapter;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="parentChapter")
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Textbook getTextbook() {
		return textbook;
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
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