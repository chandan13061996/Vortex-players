package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column
	private String username;
	@Column
	private String password;
	@Column	
	private long mobileNo;
	@Column
	private String role;
	
	public User(){}

	public User(String username, String password, long mobileNo, String role) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", role=" + role + "]";
	}
	
}
