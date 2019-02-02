package com.example.demo.controller;


import java.security.Principal;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/api/user")
	public Principal user(Principal user) {
		//System.out.println(user.getName());
		return user;
	}

}