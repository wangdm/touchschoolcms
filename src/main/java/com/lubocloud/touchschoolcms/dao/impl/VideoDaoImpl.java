package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.VideoDao;
import com.lubocloud.touchschoolcms.entity.Video;

@Repository(value = "videoDao")
public class VideoDaoImpl extends BaseDaoImpl<Video> implements VideoDao {
	
}
