package com.springboot.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername =  username.equalsIgnoreCase("admin");
		boolean isValidPassowrd = password.equals("123456");
		
		return isValidUsername && isValidPassowrd;
	}
}
