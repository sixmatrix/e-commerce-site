package com.bolton.treehouseproject.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "user_id")
	private int userId;
	
	@JoinColumn(name = "user_name", unique=true)
	private String userName;
	
	@JoinColumn(name = "user_email", unique=true)
	private String userEmail;
	
	@JoinColumn(name = "user_pass")
	private String userPass;
	
	public User() {
	}
	
	public User(String userName, String userEmail, String userPass) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPass = userPass;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPass="
				+ userPass + "]";
	}
}
