package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.beans.User;
import com.dev.service.UserServices;

@Controller
public class AddUserContorller {
	
	@Autowired
	UserServices services;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPage(ModelAndView mv) {
		mv.setViewName("addUser");
		return mv;
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ModelAndView addUser(User user, ModelAndView mv) {
		mv.setViewName("msg");
		boolean state = services.addUser(user);
		String msg = "Failed to add User Data";
		if(state) {
			msg = "Person Data added";
		}
		mv.addObject("msg",msg);
		return mv;
	}
}