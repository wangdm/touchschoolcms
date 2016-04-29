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
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid", nullable=false, unique=true)
	private int uid;
	
	@Column(name="username", nullable=false, unique=true, length=45)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="nickname")
	private String nickname;
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id")
	private Role role;

	public User(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public String getEmail(){
		return this.email;
	}

	public String getNickname(){
		return this.nickname;
	}

	public String getPassword(){
		return this.password;
	}

	public String getPhone(){
		return this.phone;
	}

	public Role getRole(){
		return this.role;
	}

	public int getUid(){
		return this.uid;
	}

	public String getUsername(){
		return this.username;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(Role role){
		this.role = role;
	}

	/**
	 * 
	 * @param uid    uid
	 */
	public void setUid(int uid){
		this.uid = uid;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}

}