package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.Repositories.UserRepository;
import com.mthree.models.Users;

@Service

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public int validateLogin(String mobileNumber,String password) {
		int c=0;
		List<Users> u=userRepository.findAll();
		for(Users user:u) {
		if(user.getMobileNumber().equals(mobileNumber) && user.getPassword().equals(password))
			c=1;
	
		}
		return c;
}

	
	
	
	public boolean mobileNumberExists(String mobileNumber)
	{
		List<Users> u=userRepository.findAll();
		for(Users user:u) {
		if(user.getMobileNumber().equals(mobileNumber))
			
	return false;
		}
		
		return true;
	}
	
	public Users getUsermobileNumber(String mobileNumber)
	{
		List<Users> u=userRepository.findAll();
		for(Users user:u) {
		if(user.getMobileNumber().equals(mobileNumber))
			
	return user;
		}
		
		return null;
	}
	
	public int addUser(Users userData) {
		int count=(int)userRepository.count();
		userData.setUserId(count+1);
		if(userRepository.existsById(userData.getUserId()))
			return 0;
		else {
			userRepository.save(userData);
			return 1;
		}
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
}
