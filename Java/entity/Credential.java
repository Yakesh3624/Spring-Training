package com.yakesh.AssetManagement.Entity;

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

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private Users user;
    
    private String userName;
    private String password;
	public Credential(int userId, Users user, String userName, String password) {
		super();
		this.userId = userId;
		this.user = user;
		this.userName = userName;
		this.password = password;
	}
	public Credential() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	@Override
	public String toString() {
		return "Credential [userId=" + userId + ", user=" + user + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	
    
	
}
