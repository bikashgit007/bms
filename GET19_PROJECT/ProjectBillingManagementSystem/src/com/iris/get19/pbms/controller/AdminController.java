package com.iris.get19.pbms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.get19.pbms.dao.DevAllocationDao;
import com.iris.get19.pbms.dao.DevAttendanceDao;
import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.DeveloperRoleDao;
import com.iris.get19.pbms.dao.ProjectConfigDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.ServiceDao;
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

	@Autowired
	ServiceDao serviceDao;

	// ProjectConfigTable

	
	@Autowired
	HttpSession session;
	
	
	public boolean checkSession(ModelMap map) {
		
		if( session.getAttribute("userObj")==null) {
			map.addAttribute("msg","unauthorized session");
			return true;
		}
			
			
		return false;
		
	}
	
	
	
	
	@RequestMapping(value = "ProjectConfigTable", method = RequestMethod.GET)
	public String projectConfigTable(ModelMap map) {

		if(checkSession(map)) {
			
			
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		map.addAttribute("ProjectConfigList", projectConfigDao.getAllConfig());

		System.out.println(projectConfigDao.getAllConfig());
		return "ProjectCon";
		}
	}

	
	
	
	
	


	
	
	
	
	
	@RequestMapping(value = "addProjectConfig", method = RequestMethod.GET)
	public String projectConfig(@ModelAttribute ProjectConfig pConfig, ModelMap map) {

		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		
		System.out.println("inside add Project" + pConfig);
		if (pConfig.getProject() == null || pConfig.getRole() == null) {

			try {
				List<Project> pList = projectDao.viewProject();
				List<DeveloperRole> rList = roleDao.viewRole();
				map.addAttribute("pList", pList);
				map.addAttribute("rList", rList);

				System.out.println("inside add Project");

				map.addAttribute("ProjectConfigList", projectConfigDao.getAllConfig());
				map.addAttribute("configObj", new ProjectConfig());

				return "addProjectConfig";

			} catch (Exception e) {
				e.printStackTrace();
				return "ErrorPage";

			}
		} else {

			try {

				System.out.println("inside  else add Project"+pConfig);

				if(pConfig.getPerHourBilling()!=0) {
				
				List<Project> pList = projectDao.viewProject();
				List<DeveloperRole> rList = roleDao.viewRole();
				map.addAttribute("pList", pList);
				map.addAttribute("rList", rList);

				projectConfigDao.updateProjectConfiguration(pConfig);
				
				
				
					
				List<ProjectConfig> ProjectConfigList = projectConfigDao.getAllConfig();

				map.addAttribute("ProjectConfigList",ProjectConfigList);
				
				map.addAttribute("pObjList",ProjectConfigList);
				
				
				
				
				return "ProjectCon";
				}
				else
				{
					map.addAttribute("msg","please enter per hour billing");
					return "ProjectCon";
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return "ErrorPage";

			}

		}
		}
	}

	@RequestMapping(value = "updateProjectConfig/{configId}", method = RequestMethod.GET)
	public String updateProjectConfig(@PathVariable int configId, ModelMap map) {
		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
		}
		else {
		try {
			ProjectConfig configObj = projectConfigDao.getConfigByConfigId(configId);
			
			List<Project> pList = projectDao.viewProject();
			List<DeveloperRole> rList = roleDao.viewRole();
				
			map.addAttribute("configObj", configObj);

			map.addAttribute("pList", pList);
			map.addAttribute("rList", rList);

			map.addAttribute("configid",configObj.getConfigid());
			map.addAttribute("msg", "config updated");
			return "addProjectConfig";
		} catch (Exception e) {

			return "ErrorPage";

		}
		}
	}

	@RequestMapping(value = "deleteProjectConfig/{configId}", method = RequestMethod.GET)
	public String deleteProjectConfig(@PathVariable int configId, ModelMap map) {
			
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		try {
			boolean b=projectConfigDao.deleteProjectConfiguration(configId);
			if(b) {
			map.addAttribute("msg", "Config Deleted!!!!");
			}
			else
			{
				map.addAttribute("msg", "couldnot delete because developer exists");
				
			}
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/ProjectConfigTable";
		} catch (Exception e) {

			return "ErrorPage";

		}
		}
	}

	/*
	 * @RequestMapping(value = "addProjectConfig", method = RequestMethod.GET)
	 * public String addProjectConfig(@ModelAttribute("configObj") ProjectConfig
	 * projectConfig) { try { boolean
	 * b=projectConfigDao.addConfiguration(projectConfig);
	 * 
	 * return "HomePage"; } catch(Exception e) {
	 * 
	 * return "ErrorPage"; }
	 * 
	 * }
	 */
	// http://localhost:1235/ProjectBillingManagementSystem/addProjectConfigThroughAjax?project%5Bprojectname%5D=BOI&role%5BroleName%5D=Tech%20Lead&location=Onsite&perHourBilling=100

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "addProjectConfigThroughAjax", method = RequestMethod.POST)
	public @ResponseBody List<ProjectConfig> addProjectConfigThroughAjax() {

		
		
		
		
		try {

			String queryString = request.getQueryString();
			Object str = request.getAttribute("item");
			System.out.println(request.getParameterNames());

			queryString = queryString.replace("%5B", ".");
			queryString = queryString.replace("%5D", "");
			queryString = queryString.replace("%20", " ");

			List<String> strList = new ArrayList<String>();

			String[] parts1 = queryString.split("&");
			for (String part1 : parts1) {
				String[] parts2 = part1.split("=");
				for (String part2 : parts2) {
					strList.add(part2);

				}
			}

			try {
				ProjectConfig projectConfig = new ProjectConfig();
				projectConfig.setProject(projectDao.getProjectByName(strList.get(1).trim()));
				projectConfig.setRole(roleDao.getRoleByName(strList.get(3).trim()));
				projectConfig.setLocation(strList.get(5));
				projectConfig.setPerHourBilling(Integer.parseInt(strList.get(7)));

				boolean b = projectConfigDao.addConfiguration(projectConfig);
				System.out.println(b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<ProjectConfig> configList = projectConfigDao.getAllConfig();
		return configList;

	}

	// project=1&role=1&location=Onsite&perHourBilling=100

	@RequestMapping(value = "addDeveloperAllocation", method = RequestMethod.GET)
	public String addDeveloperAllocation(ModelMap map) {
		
if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		
		// developerAllocationDao.allocateDeveloper();
		System.out.println("inside devallocation");
		// List<Developer> dList = developerDao.viewDeveloper();
		List<ProjectConfig> configList = projectConfigDao.getAllConfig();

		// System.out.println("Developer's List : "+dList);

		List<Developer> dallocList = devAllocationDao.getAllDeveloper();
		// dList.removeAll(dallocList);

		System.out.println("Developer's List : " + dallocList);

		map.addAttribute("devConfigObj", new DevAllocation());

		map.addAttribute("dList", dallocList);

		map.addAttribute("configList", configList);

		return "DeveloperAllocation";
		}
	}

	@RequestMapping(value = "filldevAllocation", method = RequestMethod.GET)
	public String addProjectConfig(@ModelAttribute("devConfigObj") DevAllocation devConfigObj, ModelMap map) {
		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		
		try {
			devAllocationDao.allocateDeveloper(devConfigObj);

			return "AdminHtml";
		} catch (Exception e) {

			map.addAttribute("msg", " developer already allocated ");
			return "ErrorPage";
		}
		}
	}

	@RequestMapping(value = "/fetchProjectConfigConfiguration", method = RequestMethod.GET)
	public @ResponseBody List<ProjectConfig> getProjectConfiguration() {
		
		
		
		System.out.println("I have reached here ");
		List<ProjectConfig> configList = projectConfigDao.getAllConfig();
		return configList;
	}

	@RequestMapping(value = "/fetchProjects", method = RequestMethod.GET)
	public @ResponseBody List<Project> getProjects() {

		List<Project> projectsList = projectDao.viewProject();
		return projectsList;
	}

	@RequestMapping(value = "/fetchRoles", method = RequestMethod.GET)
	public @ResponseBody List<DeveloperRole> getRoles() {

		List<DeveloperRole> rolesList = roleDao.viewRole();
		return rolesList;
	}

	@RequestMapping(value = "developerAllocated", method = RequestMethod.GET)
	public String developerAllocated(@ModelAttribute DevAllocation devAllocation, ModelMap map) {
		// developerAllocationDao.allocateDeveloper();
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		try {
			boolean b = devAllocationDao.allocateDeveloper(devAllocation);
			if (b) {

				return "AdminHtml";
			}
		} catch (Exception e) {

			map.addAttribute("msg", "Developer already allocated to a project");

			List<Developer> dList = developerDao.viewDeveloper();
			List<ProjectConfig> configList = projectConfigDao.getAllConfig();
			map.addAttribute("devConfigObj", new DevAllocation());

			map.addAttribute("dList", dList);

			map.addAttribute("configList", configList);
			return "DeveloperAllocation";

		}
		List<Developer> dList = developerDao.viewDeveloper();
		List<ProjectConfig> configList = projectConfigDao.getAllConfig();
		map.addAttribute("devConfigObj", new DevAllocation());

		map.addAttribute("dList", dList);

		map.addAttribute("configList", configList);

		return "DeveloperAllocation";
		}
	}

	@RequestMapping(value = "DeveloperBilling", method = RequestMethod.GET)
	public String developerBilling(ModelMap map) {
		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		try {
			List<DevAllocation> devAllocList = devAllocationDao.getAllDevAllocation();
			map.addAttribute("devAllocList", devAllocList);
			DevAllocation devAlloc = new DevAllocation();
			map.addAttribute("devAlloc", devAlloc);
			return "billingForm";
		} catch (Exception e) {

			return "ErrorPage";
		}
		}
	}

	@RequestMapping(value = "reportDeveloperBilling", method = RequestMethod.POST)
	public String seeDeveloperBilling(@ModelAttribute DevAllocation devAlloc, ModelMap map) {
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		try {
			double totalBill = serviceDao.getDeveloperBillingMonthly(devAlloc.getAllocationId(),
					request.getParameter("month"), Integer.parseInt(request.getParameter("year")));

			map.addAttribute("totalBill", totalBill);

			List<DevAllocation> devAllocList = devAllocationDao.getAllDevAllocation();
			map.addAttribute("devAllocList", devAllocList);
		
			map.addAttribute("devAlloc", devAlloc);

			
			map.addAttribute("month", request.getParameter("month"));
			map.addAttribute("year", request.getParameter("year"));
			
			
			return "billingForm";
		} catch (Exception e) {

			return "ErrorPage";
		}
		}
	}

	@RequestMapping(value = "ProjectBilling", method = RequestMethod.GET)
	public String projectBilling(ModelMap map) {
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		try {
			List<Project> pList = projectDao.viewProject();

			List<ProjectConfig> pConfigList = projectConfigDao.getAllConfig();

			map.addAttribute("pList", pList);

			map.addAttribute("pConfigList", pConfigList);

			map.addAttribute("projectConfig", new ProjectConfig());

			String month = null;

			map.addAttribute("month", month);
			return "ProjectBilling";

		} catch (Exception e) {

			return "ErrorPage";
		}
		}
	}

	@RequestMapping(value = "seeProjectBilling", method = RequestMethod.POST)
	public String seeProjectBilling(@ModelAttribute ProjectConfig projectConfig, Project pList, ModelMap map) {
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		try {
			double totalSalary = 0.0;

			String month = null;

			totalSalary = serviceDao.getProjectBillingMonthly(projectConfig.getConfigid(),
					request.getParameter("month"), Integer.parseInt(request.getParameter("year")));

			map.addAttribute("proejctBilling", totalSalary);

			map.addAttribute("projectConfig", projectConfig);

			map.addAttribute("pList", projectDao.viewProject());

			map.addAttribute("month",request.getParameter("month"));
			map.addAttribute("year",request.getParameter("year"));

			return "ProjectBilling";

		} catch (Exception e) {

			e.printStackTrace();
			return "ErrorPage";
		}

	}
	}
}
