package com.hexaware.AdminMicrocontroller.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin_credential")
public class Credential {
	
	@Id
    private int adminId;
	private String userName;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "adminId")
	Admin admin;

	public Credential(int adminId, String userName, String password, Admin admin) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.admin = admin;
	}

	public Credential() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Credential [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", admin="
				+ admin + "]";
	}

	
	
    
	
}
