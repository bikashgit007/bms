package com.iris.get19.pbms.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDao {
	public double getProjectBillingMonthly(int configId,String month,int year);
	public double getProjectBillingYearly();
	
	
	public double getDeveloperBillingMonthly(int configId,String month,int year);
	
	public double getDeveloperBillingYearly();
	
	
}
