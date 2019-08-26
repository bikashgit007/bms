package com.iris.get19.pbms.dao;

import com.iris.get19.pbms.dao.model.Project;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ProjectDao {
	public List<Project> viewProject();
	public Project getProjectById(int id);
}
