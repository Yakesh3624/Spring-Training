package com.hexaware.AdminMicrocontroller.dto;

public class CredentialDTO {
	
	
    private int adminId;
	private String userName;
	private String password;

	
	
	public CredentialDTO() {
		super();
		
	}

	public CredentialDTO(int adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
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

	@Override
	public String toString() {
		return "CredentialDTO [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}

	

    
    
	
}
