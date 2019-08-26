package com.iris.get19.pbms.dao;

import com.iris.get19.pbms.dao.model.DevAttendance;
import java.util.List;

import org.springframework.stereotype.Repository;




@Repository
public interface DevAttendanceDao {
	
	
	public boolean fillAttendance(DevAttendance de);
	public List<DevAttendance> viewAttendance();
	
	public double getAttendanceById(int id);

}
