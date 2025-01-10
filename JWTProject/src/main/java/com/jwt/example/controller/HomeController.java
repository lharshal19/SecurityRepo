package com.jwt.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.model.User;
import com.jwt.example.service.UserService;


@RestController
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8081/home/user
	@GetMapping("/user")
	public List<User> getUser() { 
		
		List<User> users = userService.getUsers();
		return  users;
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	

}
