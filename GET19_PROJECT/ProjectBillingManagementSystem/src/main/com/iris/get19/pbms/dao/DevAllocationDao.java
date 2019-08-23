package com.iris.get19.pbms.dao;

import com.iris.get19.pbms.dao.model.DevAllocation;

import java.util.List;

import org.springframework.stereotype.Repository;




@Repository
public interface DevAllocationDao  {
	
	public boolean allocateDeveloper(DevAllocation da);
	
	public List<DevAllocation> getAllDevAllocation();

}
