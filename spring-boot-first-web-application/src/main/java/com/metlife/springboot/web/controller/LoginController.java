package com.metlife.springboot.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.metlife.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	/*This is old way of doing things by creating a instance using a new keyword*/
	//LoginService service = new LoginService();
	
	//Injected Automatically
	@Autowired
	LoginService service;
	
	//@RequestMapping("/login")
	@RequestMapping(value="/login",method=RequestMethod.GET)

	/*@ResponseBody*/
	public String showLoginPage(/*@RequestParam String name,*/ModelMap model) {
		//model.put("name", name);
		
		return "login";
	}

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password) {
		
		boolean isValidUser  = service.validateUser(name, password);
		if(!isValidUser) {
			model.put("errorMessage","Invalid login credentials");
			return "login";
			}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}
