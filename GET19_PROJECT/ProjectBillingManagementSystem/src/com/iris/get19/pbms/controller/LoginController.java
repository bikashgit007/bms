package com.iris.get19.pbms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.Developer;


@Controller
public class LoginController {
	
	
	@Autowired
	DeveloperDao developerDao;
	
	
	@RequestMapping(value= {"/","HomePage"},method=RequestMethod.GET)
	public String getHomePage() {
		return "HomePage";
	}
	
	@RequestMapping(value="logOut",method=RequestMethod.GET)
	public String getLogOutPage(ModelMap map) {
		session.removeAttribute("userObj");
		session.invalidate();
		return "HomePage";
	}
	
	  @RequestMapping(value="Login",method=RequestMethod.GET)
	public String getLoginPage(ModelMap map) {
		Developer d = new Developer();
		map.addAttribute("dObj", d);
		
		
		
		return "LoginPage";
	}
	
	  
	  @Autowired
	 HttpSession session;
	  
	@RequestMapping(value="validate",method=RequestMethod.POST)
	public String ValidatePage(  @ModelAttribute("dObj") Developer dObj, ModelMap map) {
		
		//System.out.print("I m in validate");
		
		
		boolean b=developerDao.validateDeveloper(dObj.getId(), dObj.getPassword());
		

		if(b)
		{
			
			
			System.out.println("-----------------------------------------");
			Developer d=developerDao.getDeveloperById(dObj.getId());
			session.setAttribute("userObj",d);
			if(d.getApplicationRole().equals("Admin"))
			{
			
				return "AdminHtml";
			}
			else if(d.getApplicationRole().equals("DEO"))
				return "DataEntry";
			else
				return "ErrorPage";
		}
		
		map.addAttribute("msg", "Wrong user id or Password,try again!!");
		return "LoginPage";
	}
	
	
	
}
