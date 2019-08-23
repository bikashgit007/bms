package com.iris.get19.pbms.dao;

import com.iris.get19.pbms.dao.model.Developer;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperDao {
	public List<Developer> viewDeveloper();
	public Developer getDeveloperById(int id);
	public boolean validateDeveloper(int id,String password);
	}
