package com.lubocloud.touchschoolcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RBDevice")
public class RBDevice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=20)
	private String name;
    
	@Column(name="push_uri", length=256)
    private String pushUri;
    
	@Column(name="play_uri", length=256)
    private String playUri;
    
	@Column(name="recorder_status")
    private int recorderStatus;
    
	@Column(name="rtmp_status")
    private int rtmpStatus;
    
    @OneToOne
    @JoinColumn(name="roomId")
    private Room room;

	public RBDevice(){

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

	public String getPushUri() {
		return pushUri;
	}

	public void setPushUri(String pushUri) {
		this.pushUri = pushUri;
	}

	public String getPlayUri() {
		return playUri;
	}

	public void setPlayUri(String playUri) {
		this.playUri = playUri;
	}

	public int getRecorderStatus() {
		return recorderStatus;
	}

	public void setRecorderStatus(int recorderStatus) {
		this.recorderStatus = recorderStatus;
	}

	public int getRtmpStatus() {
		return rtmpStatus;
	}

	public void setRtmpStatus(int rtmpStatus) {
		this.rtmpStatus = rtmpStatus;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}