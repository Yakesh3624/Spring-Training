package com.hexaware.assetmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Credential {
	
	@Id
    private int userId;
	@Column(nullable = false, unique=true,name = "user_name")
    private String userName;
	@Column(nullable = false, unique=true)
    private String password;
	
    @OneToOne
    @MapsId
    @JoinColumn(name="userId")
    private Users user;

	public Credential(int userId, String userName, String password, Users user) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Credential [userId=" + userId + ", userName=" + userName + ", password=" + password + ", user=" + user
				+ "]";
	}
    
    
	
}
