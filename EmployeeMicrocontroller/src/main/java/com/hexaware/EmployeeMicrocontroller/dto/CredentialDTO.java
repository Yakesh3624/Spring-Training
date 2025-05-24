package com.hexaware.EmployeeMicrocontroller.dto;

public class CredentialDTO {
	
    private int employeeId;
	private String userName;
	private String password;
	
	public CredentialDTO() {
		super();
	}

	public CredentialDTO(int employeeId, String userName, String password) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
		return "CredentialDTO [employeeId=" + employeeId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
    
	
}
