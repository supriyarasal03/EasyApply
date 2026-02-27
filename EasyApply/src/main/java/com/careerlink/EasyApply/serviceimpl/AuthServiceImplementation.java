	package com.careerlink.EasyApply.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerlink.EasyApply.dao.AuthRepository;
import com.careerlink.EasyApply.dto.Login;
import com.careerlink.EasyApply.entity.User;
import com.careerlink.EasyApply.service.AuthService;

@Service	
public class AuthServiceImplementation  implements AuthService{
	
	@Autowired
	AuthRepository repo;

	@Override
	public User register(User user) {
		User saveuser =repo.save(user);
		return saveuser;
	}

	@Override
	public User login(Login login) {
		
	User user =	repo.findByEmail(login.getEmail());
	if(user==null) {
	throw new RuntimeException("Email not exist");
		
	}
	
	if(!user.getPassword().equals(login.getPassword())) {
		throw new RuntimeException("Invalid Password"); 
	}
	
	
	
	
	
		
		return user;
	}
	

}
	