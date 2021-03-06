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
 * 课程视频的分类实体
 */
@Entity
@Table(name = "Category")
public class Category {

    public enum CategoryType{
        Course,
        Subject,
        Group
    }
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=20)
	private String name;
    
	@Column(name="type", nullable=false)
    private CategoryType type;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	Category parentCategory;

	public Category(){

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

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parent) {
		this.parentCategory = parent;
	}
}