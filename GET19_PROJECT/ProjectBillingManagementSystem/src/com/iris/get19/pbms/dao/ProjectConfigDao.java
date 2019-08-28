package com.iris.get19.pbms.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.model.ProjectConfig;



public interface ProjectConfigDao {

		public boolean addConfiguration(ProjectConfig projectConfig);
		
		public List<ProjectConfig> getAllConfig();
		public ProjectConfig getConfigByAllocationId(int allocationId);
		
		public ProjectConfig getConfigByConfigId(int configId);

		public List<ProjectConfig> getallConfigByProjectId(int projectId);
		
		public double getTotalPerHourBulling(int projectId);
		
		public boolean updateProjectConfiguration(ProjectConfig pConfig);
		
		
		public boolean deleteProjectConfiguration(int pConfig);
		
		
		
		
}
