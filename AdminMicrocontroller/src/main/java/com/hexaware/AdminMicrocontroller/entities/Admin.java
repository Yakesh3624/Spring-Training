package com.hexaware.AdminMicrocontroller.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	private int adminId;
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
	
	
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String firstName, String lastName, String email, String gender,
			String contactNumner, String address) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contactNumner = contactNumner;
		this.address = address;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", contactNumner=" + contactNumner + ", address=" + address + "]";
	}

	
	
	
	
}
