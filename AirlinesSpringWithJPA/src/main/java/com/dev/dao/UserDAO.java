package com.dev.dao;

import java.util.List;

import com.dev.beans.User;

public interface UserDAO {
	public boolean addUser(User user);
	public List<User> searchByName(String name);
	public boolean deleteUser(String name);
	public boolean updateUser(User user);
}
