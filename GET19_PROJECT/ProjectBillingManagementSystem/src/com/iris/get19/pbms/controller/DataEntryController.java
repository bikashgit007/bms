package com.iris.get19.pbms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.get19.pbms.dao.DevAllocationDao;
import com.iris.get19.pbms.dao.DevAttendanceDao;
import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.DevAttendance;
import com.iris.get19.pbms.dao.model.Developer;



@Controller
public class DataEntryController {
	
	
	@Autowired
	DeveloperDao developerDao;
	@Autowired
	DevAttendanceDao dataEntryDao;
	@Autowired
	DevAllocationDao devAllocationDao;
	
	
	@Autowired
	HttpSession session;

	
public boolean checkSession(ModelMap map) {
		
		if(session.getAttribute("userObj")==null) {
			map.addAttribute("msg","unauthorized session");
			return true;
		}
			
			
		return false;
		
	}
	
	
	@RequestMapping(value = "fillattendance", method = RequestMethod.GET)
	public String fillAttendance(ModelMap map) {
		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		//Develepor d=developerDao.
		
		//List<Developer> dList = developerDao.viewDeveloper();
		map.addAttribute("dataEntry",new DevAttendance());
		
		
		
		
		List<Developer> dList = devAllocationDao.getAllAllocatedDeveloper();
		map.addAttribute("dList", dList);
		System.out.println("inside fill attendence");
		
		
		
		
		
		
		
		return "DataEntryAttendance";
		}
		
	}
	
	@RequestMapping(value = "addAttendance", method = RequestMethod.POST)
	public String addAttendance(@ModelAttribute("dataEntry") DevAttendance devAttendance ,ModelMap map) {
		
		
		if(checkSession(map)) {
			
			return "redirect:http://localhost:1237/ProjectBillingManagementSystem/Login";
			
			
			
			
		}
		else {
		
		
		try {
			 dataEntryDao.fillAttendance(devAttendance);
			}
			catch(Exception e) {
				map.addAttribute("msg","cannot update past data");
				return "DataEntry";
				
				
			}
			return "DataEntry";
			
		
		
	}
	}
	
}


