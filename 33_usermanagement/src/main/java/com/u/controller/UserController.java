package com.u.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.u.entity.User;
import com.u.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//load login form
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("user",new User());
		return "index";
	}
	
	//handle login form
	
	@PostMapping("/login")
	public String handleLogin(User user, Model model)
	{
		User userobj = userService.getUser(user.getEmail(), user.getPwd());
		
		if(userobj==null)
		{
			model.addAttribute("emsg","invalid credential");
			return "index";
		}
		else
		{
			model.addAttribute("smsg", userobj.getName()+"welcome to you");
			return "dashboard";
		}
	}
	
	//load register form
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("user",new User());
		return "register";
	}
	
	//handle register form
	@PostMapping("/register")
	public String registerHandle(User user,Model model)
	{
		boolean saveUser = userService.saveUser(user);
		if(saveUser )
		{
			model.addAttribute("smsg","user register successfully");
		}
		else
		{
			model.addAttribute("emsg","failed user registeration ");
		}
		
		return "register";
	}
	
	
	@GetMapping("/logout")
	public String loout(Model model)
	{
		model.addAttribute("user",new User());
		return "index";
	}
	
	
	
}
