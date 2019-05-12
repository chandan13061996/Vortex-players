package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev.service.UserServices;

@Controller
public class DeleteUserController {
	
	@Autowired
	UserServices services;
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView deletePage(ModelAndView mv){
		mv.setViewName("delete");
		return mv;
	}
	
	@RequestMapping(value="deleteByName", method=RequestMethod.GET)
	public ModelAndView deleteByName(ModelAndView mv, 
			@RequestParam("username") String name) {
		mv.setViewName("msg");
		boolean state = services.deleteUser(name);
		
			String msg = "Failed to delete User Data";
			if(state) {
				msg = "Person Data deleted";
				}
			mv.addObject("msg",msg);
		return mv;
	}
	

}
