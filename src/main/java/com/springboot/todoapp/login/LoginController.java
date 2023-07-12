package com.springboot.todoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		//Authentication
		//name - admin
		//password - 123456
		
		if(authenticationService.authenticate(name, password)) {
			return "welcome";
		}
		
		model.put("error", "Wrong username or password, please try again!");
		
		return "login";
	}
}
