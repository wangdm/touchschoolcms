package com.lubocloud.touchschoolcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.lubocloud.touchschoolcms.dao.ScheduleDao;
import com.lubocloud.touchschoolcms.entity.Schedule;

@Repository(value = "scheduleDao")
public class ScheduleDaoImpl extends BaseDaoImpl<Schedule> implements ScheduleDao {

}
