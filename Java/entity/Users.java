package com.yakesh.AssetManagement.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Users {

	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String userRole;
	private String gender;
	private String contactNumner;
	private String address;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Credential credential;

	@OneToMany(mappedBy = "user")
	private List<AssetAllocation> assetAllocations;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ServiceRequest> serviceRequests;

	@OneToMany(mappedBy = "user")
	private List<AuditRequest> auditRequests;

	public Users(int userId, String firstName, String lastName, String email, String userRole, String gender,
			String contactNumner, String address, Credential credential, List<AssetAllocation> assetAllocations,
			List<ServiceRequest> serviceRequests, List<AuditRequest> auditRequests) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.gender = gender;
		this.contactNumner = contactNumner;
		this.address = address;
		this.credential = credential;
		this.assetAllocations = assetAllocations;
		this.serviceRequests = serviceRequests;
		this.auditRequests = auditRequests;
	}
	
	

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


	
	

	public Users() {
		super();
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

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public List<AssetAllocation> getAssetAllocations() {
		return assetAllocations;
	}

	public void setAssetAllocations(List<AssetAllocation> assetAllocations) {
		this.assetAllocations = assetAllocations;
	}

	public List<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public List<AuditRequest> getAuditRequests() {
		return auditRequests;
	}

	public void setAuditRequests(List<AuditRequest> auditRequests) {
		this.auditRequests = auditRequests;
	}



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", gender=" + gender + ", contactNumner=" + contactNumner + ", address="
				+ address + ", credential=" + credential + ", assetAllocations=" + assetAllocations
				+ ", serviceRequests=" + serviceRequests + ", auditRequests=" + auditRequests + "]";
	}
	
	

}
