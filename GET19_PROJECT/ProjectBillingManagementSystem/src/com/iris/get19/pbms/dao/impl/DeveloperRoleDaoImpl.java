package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.DeveloperRoleDao;
import com.iris.get19.pbms.dao.model.DeveloperRole;
import com.iris.get19.pbms.dao.model.Project;




@Repository(value="roleDao")
@Transactional
public class DeveloperRoleDaoImpl implements DeveloperRoleDao{
	
	@Autowired
	SessionFactory sf;
	
	public List<DeveloperRole> viewRole() {
		try{
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DeveloperRole");
			 return q.getResultList();
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public DeveloperRole viewRoleById(int id) {
		try{
			Session session=sf.getCurrentSession();
			DeveloperRole rObj=session.get(DeveloperRole.class,id);
			 return rObj;
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public DeveloperRole getRoleByName(String name) {
		try {
			System.out.println("Role Name "+name);
			Session session=sf.getCurrentSession();
			Query<DeveloperRole> q=session.createQuery("From DeveloperRole where  roleName=:x");
			q.setParameter("x",name);
			
			if(q.getResultList().size()!=0) {
				System.out.println("I m finding the data");
			
				return q.getResultList().get(0);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			
			return null;
	}

	
	

}
