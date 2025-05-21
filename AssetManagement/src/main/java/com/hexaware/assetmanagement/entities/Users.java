package com.hexaware.assetmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	private int userId;
	@Column(nullable = false,name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false,name = "role")
	private String userRole;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false, unique=true,name = "phone")
	private String contactNumner;
	@Column(nullable = false)
	private String address;
	
	public Users(int userId, String firstName, String lastName, String email, String userRole, String gender,
			String contactNumner, String address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.gender = gender;
		this.contactNumner = contactNumner;
		this.address = address;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
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
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", gender=" + gender + ", contactNumner=" + contactNumner + ", address="
				+ address + "]";
	}
	
	
	
}
