package com.hexaware.assetmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private int employeeId;
	@Column(nullable = false,name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false, unique=true,name = "phone")
	private String contactNumner;
	@Column(nullable = false)
	private String address;
	
	
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String firstName, String lastName, String email, String gender,
			String contactNumner, String address) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contactNumner = contactNumner;
		this.address = address;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumner() {
		return contactNumner;
	}
	public void setContactNumner(String contactNumner) {
		this.contactNumner = contactNumner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", contactNumner=" + contactNumner + ", address=" + address + "]";
	}

	
	
	
}
