package com.u.service;

import com.u.entity.User;

public interface UserService {

	//method for user register
	public boolean saveUser(User user);
	
	//method for user login
	public User getUser(String email,String pwd);
	
}
