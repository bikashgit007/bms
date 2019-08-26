package com.iris.get19.pbms.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.DevAllocationDao;
import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectConfig;




@Repository(value="devAllocationDao")
@Transactional
public class DevAllocationDaoImpl implements DevAllocationDao,Serializable {

	@Autowired
	SessionFactory sf;
	
	public boolean allocateDeveloper(DevAllocation da) {
		try {
			Session session=sf.getCurrentSession();
			session.persist(da);
			return true;
		} 
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<DevAllocation> getAllDevAllocation() {
		Session session=sf.getCurrentSession();
		Query query=session.createQuery("from DevAllocation");
		return query.getResultList();
	}

	@Override
	public ProjectConfig getProjectConfigByAllocationId(int allocationId) {
		

		try {
			
			
			Session session=sf.getCurrentSession();
			ProjectConfig pCfg=session.get(ProjectConfig.class,allocationId);
			return pCfg;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	@Override
	public DevAllocation getDeveloperByAllocationId(int allocationId) {
		

		try {
			
			System.out.println(allocationId);
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DevAllocation where configid=:x");
			q.setParameter("x", allocationId);
			
			
			
			DevAllocation dev=(DevAllocation)q.getResultList().get(0);
			return dev;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	/*
	@Override
	public ProjectConfig getBillingById(ProjectConfig pConfig) {
	
		try {
			
			Session session=sf.getCurrentSession();
			ProjectConfig pConfig=session.get(ProjectConfig.class,configid);
			return pConfig;
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			return null;
		
	}


*/

	/*
	@Override
	public double getBillingById(int id) {
		
		try {
		Session session=sf.getCurrentSession();
		
		DevAllocation devAlloc=new DevAllocation();
		devAlloc=session.get(DevAllocation.class, id);
		
		int configId=devAlloc.getAllocationId();
			
		
		ProjectConfig pc=new ProjectConfig();
		
		pc=session.get(ProjectConfig.class,configId);
		
		return pc.getPerHourBilling();
		
		
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return 0;
	}


*/
	
	



}
