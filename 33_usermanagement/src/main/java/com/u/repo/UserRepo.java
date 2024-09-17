package com.u.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.u.entity.User;

public interface UserRepo  extends JpaRepository<User,Integer>{
	
	public User findByEmailAndPwd(String email,String pwd);

}
