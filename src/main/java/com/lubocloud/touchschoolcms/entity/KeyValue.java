package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KeyValue")
public class KeyValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="k", nullable=false, unique=true, length=20)
	private String key;
    
	@Column(name="v", nullable=false, length=40)
	private String value;
	
	//用户相关设置
	public static String defaultUserRole = "defaultUserRole";
	public static String enableRegister = "enableRegister";
	
	//课程视频相关设置
	public static String courseApproval = "courseApproval";

	public KeyValue(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}