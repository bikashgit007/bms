package com.iris.get19.pbms.dao;

import java.util.List;

import com.iris.get19.pbms.dao.model.DeveloperRole;





public interface DeveloperRoleDao {
	public List<DeveloperRole> viewRole();
	public DeveloperRole viewRoleById(int id);
	public DeveloperRole getRoleByName(String name);
}
