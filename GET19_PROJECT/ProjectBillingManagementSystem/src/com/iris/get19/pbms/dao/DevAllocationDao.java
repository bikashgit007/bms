package com.iris.get19.pbms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectConfig;


public interface DevAllocationDao  {
	
	public boolean allocateDeveloper(DevAllocation da);
	public List<DevAllocation> getAllDevAllocation();
	
	public ProjectConfig getProjectConfigByAllocationId(int devAllocationId);
	
	public DevAllocation getDeveloperByAllocationId(int allocationId);

	public List<DevAllocation> getDeveloperByConfigId(int configId);
	
	
	public List<Developer> getAllUnAllocatedDeveloper();
	public List<Developer> getAllAllocatedDeveloper();
	
	
	public List<Developer> getAllDeveloper();
	
	
	
}
