package com.metlife.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateUser(String userid,String password) {
		//balaji,welcome123
		return userid.equalsIgnoreCase("balaji") && password.equalsIgnoreCase("12345");
	}

}
