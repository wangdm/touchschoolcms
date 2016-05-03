package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Textbook")
public class Textbook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="title", nullable=false, unique=true, length=60)
	private String title;
    
    @ManyToOne
    @JoinColumn(name="categoryId", referencedColumnName="id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name="publisherId", referencedColumnName="id")
    private Publisher publiser;
    
    @ManyToOne
    @JoinColumn(name="subjectId", referencedColumnName="id")
    private Subject subject;

	public Textbook(){

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Publisher getPubliser() {
		return publiser;
	}

	public void setPubliser(Publisher publiser) {
		this.publiser = publiser;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}