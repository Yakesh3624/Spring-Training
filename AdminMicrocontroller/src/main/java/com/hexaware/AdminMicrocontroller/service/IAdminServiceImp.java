package com.hexaware.AdminMicrocontroller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.entities.Credential;
import com.hexaware.AdminMicrocontroller.repository.IAdminRepository;
import com.hexaware.AdminMicrocontroller.repository.ICredentialRepository;

@Service
public class IAdminServiceImp implements IAdminService {

	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	ICredentialRepository credentialRepo;
	
	@Override
	public Admin addAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public String deleteAdmin(int adminId) {
		
		adminRepo.deleteById(adminId);
		return adminId+" deleted successfully";
	}

	@Override
	public Admin getAdminById(int adminId) {
		
		return adminRepo.findById(adminId).orElse(null);
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return adminRepo.findAll();
	}

	@Override
	public Credential addCredential(Credential credential) {
		
		return credentialRepo.save(credential);
	}

	@Override
	public int updatePassword(String userName, String password) {
		
		return credentialRepo.updatePassword(userName, password);
	}

	@Override
	public String deleteCredential(int adminId) {
		
		credentialRepo.deleteById(adminId);
		return adminId+" credential deleted successfully";
	}

	@Override
	public Credential getCredentialByAdminId(int adminId) {
		
		return credentialRepo.findById(adminId).orElse(null);
	}
	
	@Override
	public Credential getCredentialByUserName(String userName) {
		
		return credentialRepo.findByUserName(userName);
	}

	@Override
	public List<Credential> getAllCredentials() {
		
		return credentialRepo.findAll();
	}

	@Override
	public Credential authenticate(String userName, String password) {
		
		return credentialRepo.authenticate(userName, password);
	}

    
}
