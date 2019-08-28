package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.ProjectConfigDao;
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
			Query query=session.createQuery("from ProjectConfig order by configid");
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

	

	@Override
	public List<ProjectConfig> getallConfigByProjectId(int projectId) {
		
		try {
			Session session=sf.getCurrentSession();
			
			
			System.out.println("inside projectconfig"+projectId);
			
			Query q=session.createQuery("from ProjectConfig where projectid=:x");
			q.setParameter("x",projectId);
			
			return q.getResultList();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return null;
	}

	@Override
	public double getTotalPerHourBulling(int projectId) {
		
		
		try {
		Session session=sf.getCurrentSession();
		
		
		System.out.println("inside projectconfig"+projectId);
		
		Query q=session.createQuery("select sum(perHourBilling) from ProjectConfig where projectid=:x");
		q.setParameter("x",projectId);
		
		System.out.println("inside projectconfig"+q.getResultList().get(0));
		
		String s= q.getResultList().get(0).toString();
		
		
		System.out.println("inside projectconfig"+s);
		
		
		return Double.valueOf(s);
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
		
		return 0;
	}

	
	public boolean updateProjectConfiguration(ProjectConfig pConfig) {
		try {
			
			Session session=sf.getCurrentSession();
			/*
			 * Query q=session.createQuery("update ProjectConfig set projectid=:y,roleId=:z,location=:a,perHourBilling=:b where configid=:m");
		
			q.setParameter("y",pConfig.getProject().getProjectid());
			q.setParameter("z", pConfig.getRole().getRoleId());
			q.setParameter("a",pConfig.getLocation());
			q.setParameter("b", pConfig.getPerHourBilling());
			q.setParameter("m", pConfig.getConfigid());
			
			q.executeUpdate();
				 */
			session.saveOrUpdate(pConfig);
			System.out.println(pConfig);
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	
	public boolean deleteProjectConfiguration(int pConfig) {
		try {
			
			Session session=sf.getCurrentSession();
			
			Query q=session.createQuery("delete from ProjectConfig where configid=:x");
			q.setParameter("x",pConfig);
			int b=q.executeUpdate();
			if(b!=0) {
			return true;
			}
			else
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}


	public ProjectConfig getConfigByConfigId(int configId) {
		
		
		Session session=sf.getCurrentSession();
		ProjectConfig pConfig=session.get(ProjectConfig.class,configId);
		
		return pConfig;
	}

	}
