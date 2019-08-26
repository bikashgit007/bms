package com.iris.get19.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.get19.pbms.dao.DevAllocationDao;
import com.iris.get19.pbms.dao.DevAttendanceDao;
import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.DeveloperRoleDao;
import com.iris.get19.pbms.dao.ProjectConfigDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.DeveloperRole;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfig;


@Controller
public class AdminController {
	
	@Autowired
	ProjectDao projectDao;
	@Autowired
	DeveloperRoleDao roleDao;
	@Autowired
	DeveloperDao developerDao;
	
	
	@Autowired
	ProjectConfigDao projectConfigDao;
	
	@Autowired
	DevAllocationDao devAllocationDao;
	
	@Autowired
	DevAttendanceDao devAttendanceDao;
	
	
	@RequestMapping(value = "ProjectConfig", method = RequestMethod.GET)
	public String projectConfig(ModelMap map) {
		List<Project> pList = projectDao.viewProject();
		List<DeveloperRole> rList=roleDao.viewRole();
		
		
		map.addAttribute("configObj",new ProjectConfig());
		map.addAttribute("pList", pList);
		map.addAttribute("rList", rList);
		
		return "ProjectCon";
		
		
	}
	
	@RequestMapping(value = "addProjectConfig", method = RequestMethod.GET)
	public String addProjectConfig(@ModelAttribute("configObj") ProjectConfig projectConfig) {
		try {
		boolean b=projectConfigDao.addConfiguration(projectConfig);
	
		return "HomePage";
		}
		catch(Exception e) {
		
		return "ErrorPage";
		}
		
	}
	
	@RequestMapping(value = "addDeveloperAllocation", method = RequestMethod.GET)
	public String addDeveloperAllocation(ModelMap map ) {
		//developerAllocationDao.allocateDeveloper();
		
		List<Developer> dList = developerDao.viewDeveloper();
		List<ProjectConfig> configList=projectConfigDao.getAllConfig();
	
		System.out.println("Developer's List : "+dList);
		
		
		map.addAttribute("devConfigObj",new DevAllocation());	
		
		map.addAttribute("dList", dList);
		
		
		map.addAttribute("configList", configList);
		
		
		
		
		return "DeveloperAllocation";
		
		
	}
	
	
	@RequestMapping(value = "developerAllocated", method = RequestMethod.GET)
	public String developerAllocated(@ModelAttribute DevAllocation  devAllocation, ModelMap map ) {
		//developerAllocationDao.allocateDeveloper();
		
		try {
		boolean b=devAllocationDao.allocateDeveloper(devAllocation);
		if(b) {
			
			return "HomePage";
		}
		}
		catch(Exception e) {
			
			map.addAttribute("msg","Developer already allocated to a project");
			
			List<Developer> dList = developerDao.viewDeveloper();
			List<ProjectConfig> configList=projectConfigDao.getAllConfig();
			map.addAttribute("devConfigObj",new DevAllocation());	
			
			
			map.addAttribute("dList", dList);
			
			
			map.addAttribute("configList", configList);
			return "DeveloperAllocation";
			
		}
		
		
		
		
		List<Developer> dList = developerDao.viewDeveloper();
		List<ProjectConfig> configList=projectConfigDao.getAllConfig();
		map.addAttribute("devConfigObj",new DevAllocation());	
		
		
		map.addAttribute("dList", dList);
		
		
		map.addAttribute("configList", configList);
		
		
		return "DeveloperAllocation";
		
		
	}
	
	
	
	@RequestMapping(value ="DeveloperBilling",method=RequestMethod.GET)
	public String developerBilling(ModelMap map) {
		
		List<DevAllocation> devAllocList=devAllocationDao.getAllDevAllocation();
		map.addAttribute("devAllocList", devAllocList);
		DevAllocation devAlloc=new DevAllocation();
		map.addAttribute("devAlloc", devAlloc);
		return "billingForm";
		
		
		
	}
	
	@RequestMapping(value ="reportDeveloperBilling",method=RequestMethod.POST)
	public String seeDeveloperBilling(@ModelAttribute DevAllocation devAlloc,ModelMap map) {
		
		
		System.out.println(devAlloc);
		
		ProjectConfig pConfig=devAllocationDao.getProjectConfigByAllocationId(devAlloc.getAllocationId());
		
		System.out.println(pConfig);
		
		
		
		DevAllocation devAllocation=devAllocationDao.getDeveloperByAllocationId(devAlloc.getAllocationId());
		
		
		
		System.out.println(devAllocation);
		
		
		
		
		double totalWorkingHour=devAttendanceDao.getAttendanceById(devAllocation.getDeveloper().getId());
		
		
		
		
		
		System.out.println(totalWorkingHour);
		
		double totalBill=(totalWorkingHour)*(pConfig.getPerHourBilling());
		
		
		
		
		
		map.addAttribute("totalBill",totalBill);
		
		
		
		
		
		List<DevAllocation> devAllocList=devAllocationDao.getAllDevAllocation();
		map.addAttribute("devAllocList", devAllocList);
		//boolean totalBill=pConfig.getPerHourBilling()*
		
		
		
		
		
		
		
		
		
		
		
		
		//int devId=devAlloc.getDeveloper().getId();
		
		
		//System.out.println(pConfig);
		
		/*
		
		DeveloperAllocation 
		
		
		
		
		
		
		
		
		double totalBilling=(devAttendanceDao.getAttendanceById(devAlloc.getDeveloper().getId())*pConfig.getPerHourBilling());
		
		
		map.addAttribute("totalBill",String.valueOf(totalBilling));
		*/
		map.addAttribute("devAlloc", devAlloc);
		
		return "billingForm";
		
		
		
	}
	
	
	@RequestMapping(value ="ProjectBilling",method=RequestMethod.GET)
	public String projectBilling(ModelMap map) {
		
		List<ProjectConfig> pConfigList=projectConfigDao.getAllConfig();
		
		map.addAttribute("pConfigList",pConfigList);
		
		
		map.addAttribute("projectConfig",new ProjectConfig());
		
		
		return "ProjectBilling";
		
		
		
	}
	
	
	
	
}
