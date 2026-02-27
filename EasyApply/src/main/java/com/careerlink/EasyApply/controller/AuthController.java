package com.careerlink.EasyApply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerlink.EasyApply.dto.Login;
import com.careerlink.EasyApply.entity.User;
import com.careerlink.EasyApply.serviceimpl.AuthServiceImplementation;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5173")
public class AuthController {
	
	@Autowired
	AuthServiceImplementation service;
	
	@GetMapping("/")
	public String greet() {
		return "Hello	";
	}
	
	
	@PostMapping("/saved")
	public ResponseEntity<User> register(@RequestBody User user) {
	 User saveuser=	service.register(user);
		return ResponseEntity.status(HttpStatus.OK).body(saveuser);
	}
	
	
	@PostMapping("/login")
	// ? return anything
	public ResponseEntity<?> login(@RequestBody Login login) {
		try {
			 User loguser=	service.login(login);
			 return ResponseEntity.status(HttpStatus.OK).body(loguser);
			
		}
		
		catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED ).body("invalid email and password"); 	 
			
		}
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
