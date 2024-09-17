package com.u.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.u.entity.User;
import com.u.repo.UserRepo;
import com.u.utils.EmailUtils;
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		User save = userRepo.save(user);
		String body="your account created";
		String subject="congratulation";
		
		if(save.getUid()!=null)
		{
			//emailUtils.sendEmail(save.getEmail(), body, subject);
			return true;
		}
		
		return false;
	}

	@Override
	public User getUser(String email, String pwd) {
		// TODO Auto-generated method stub
		User byEmailAndPwd = userRepo.findByEmailAndPwd(email, pwd);
		
		return byEmailAndPwd;
	}

}
