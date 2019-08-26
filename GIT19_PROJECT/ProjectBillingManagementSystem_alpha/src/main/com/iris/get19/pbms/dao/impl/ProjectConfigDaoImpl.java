package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.ProjectConfigDao;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectConfig;


@Repository(value="projectConfigDao")
@Transactional
public class ProjectConfigDaoImpl implements ProjectConfigDao {
		
	@Autowired
	SessionFactory sf;
		
	public boolean addConfiguration(ProjectConfig projectConfig) {
		try {
			Session session = sf.getCurrentSession();
			session.persist(projectConfig);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
		
		return false;
	}

	public List<ProjectConfig> getAllConfig() {
		try {
			
			Session session=sf.getCurrentSession();
			Query query=session.createQuery("from ProjectConfig");
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProjectConfig getConfigByAllocationId(int allocationId) {
		try {
			
			Session session=sf.getCurrentSession();
			ProjectConfig pCfg=new ProjectConfig();
			
			System.out.println("inside getConfigByAllocationId "+allocationId);
			
				 pCfg=session.get(ProjectConfig.class, allocationId);
			
				 System.out.println(pCfg);
				 
				 System.out.println("after query ");
			return pCfg;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	
	}

	
	
	
