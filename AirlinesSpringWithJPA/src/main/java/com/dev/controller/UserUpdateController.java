package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.beans.User;
import com.dev.service.UserServices;

@Controller
public class UserUpdateController {
	
	@Autowired
	UserServices services;
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updatePage(ModelAndView mv) {
		mv.setViewName("updateUser");
		return mv;
	}
	
	@RequestMapping(value="updateUser", method=RequestMethod.GET)
	public ModelAndView updateUser(User user, ModelAndView mv) {
		mv.setViewName("msg");
		boolean state = services.updateUser(user);
		String msg = "Failed to update User Data";
		if(state) {
			msg = "Person Data updated";
		}
		mv.addObject("msg",msg);
		return mv;
	}
}
