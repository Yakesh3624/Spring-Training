package com.hexaware.EmployeeMicrocontroller.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee_credential")
public class Credential {
	
	@Id
    private int employeeId;
	private String userName;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "employeeId")
	Employee employee;
	
	

	public Credential() {
		super();
	}



	public Credential(int employeeId, String userName, String password, Employee employee) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.password = password;
		this.employee = employee;
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



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	@Override
	public String toString() {
		return "Credential [employeeId=" + employeeId + ", userName=" + userName + ", password=" + password
				+ ", employee=" + employee + "]";
	}

	
	
    
	
}
