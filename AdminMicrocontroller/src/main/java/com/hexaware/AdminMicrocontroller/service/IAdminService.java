package com.hexaware.AdminMicrocontroller.service;

import java.util.List;

import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.entities.Credential;


public interface IAdminService {
	
	Admin addAdmin(Admin user);
	Admin updateAdmin(Admin user);
	String deleteAdmin(int userId);
	Admin getAdminById(int userId);
	List<Admin> getAllAdmins();
	
	Credential addCredential(Credential credential);
	int updatePassword(String userName, String password);
	String deleteCredential(int userId);
	Credential getCredentialByAdminId(int userId);
	Credential getCredentialByUserName(String userName);
	List<Credential> getAllCredentials();
	Credential authenticate(String userName, String password);
}
