package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.beans.User;
import com.dev.dao.UserDAO;
@Service
public class UserServices implements Services{

	@Autowired
	private UserDAO dao;

	public boolean addUser(User user) {
		return dao.addUser(user);
	}
	

	@Override
	public List<User> searchByName(String name) {
		
		return dao.searchByName(name);
	}

	@Override
	public boolean deleteUser(String name) {
		return dao.deleteUser(name);
	}


	@Override
	public boolean updateUser(User user) {
		
		return dao.updateUser(user);
	}





	
}


