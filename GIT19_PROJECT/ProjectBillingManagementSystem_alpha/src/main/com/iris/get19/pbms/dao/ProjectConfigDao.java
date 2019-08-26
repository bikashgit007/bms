package com.iris.get19.pbms.dao;

import com.iris.get19.pbms.dao.model.ProjectConfig;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ProjectConfigDao {

		public boolean addConfiguration(ProjectConfig projectConfig);
		
		public List<ProjectConfig> getAllConfig();
		
		public ProjectConfig getConfigByAllocationId(int allocationId);
		
}
