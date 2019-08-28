package com.iris.get19.pbms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.model.DevAttendance;


public interface DevAttendanceDao {
	
	
	public boolean fillAttendance(DevAttendance de);
	public List<DevAttendance> viewAttendance();
	public double getAttendanceById(int id);
	
	public double getAttendanceById(int id,String month,int year);

}
