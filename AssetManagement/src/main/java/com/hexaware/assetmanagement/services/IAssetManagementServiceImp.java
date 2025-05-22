package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.Credential;
import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.entities.Users;
import com.hexaware.assetmanagement.repositories.ICredentialRepository;
import com.hexaware.assetmanagement.repositories.IUsersRepository;
import com.hexaware.assetmanagement.restcontrollers.UsersRestController;

@Service
public class IAssetManagementServiceImp implements IAssetManagementService {

    private final UsersRestController usersRestController;

	@Autowired
	IUsersRepository userRepo;
	@Autowired
	ICredentialRepository credentialRepo;

    IAssetManagementServiceImp(UsersRestController usersRestController) {
        this.usersRestController = usersRestController;
    }
	
	@Override
	public Users addUser(Users user) {
		
		return userRepo.save(user);
	}

	@Override
	public Users getUserById(int userId) {
		
		return userRepo.findById(userId).orElse(null);
	}

	@Override
	public List<Users> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public Users updateUser(Users user) {
		
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(int userId) {
		
		userRepo.deleteById(userId);
		return userId+" Deleted Successfully";
	}

	@Override
	public Credential addCredential(Credential credential) {
		
		return credentialRepo.save(credential);
	}

	@Override
	public Credential getCredentialByUserId(int userId) {
		
		return credentialRepo.findById(userId).orElse(null);
	}

	@Override
	public Credential authenticate(String userName, String password) {
		
		return credentialRepo.findByUserName(userName);
	}

	@Override
	public int updatePassword(String userName, String password) {
		
		return credentialRepo.updatePassword(userName, password);
	}

	@Override
	public String deleteCredential(int userId) {
		
		credentialRepo.deleteById(userId);
		return userId+" deleted  Successfully";
	}

	@Override
	public Asset addAsset(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset getAssetByNo(int assetNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> getAllAssets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> getAssetsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset updateAsset(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAsset(int assetNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetAllocation allocateAssetToUser(int userId, int assetNo, LocalDate returnDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetAllocation getAllocationById(int allocationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetAllocation> getAllAllocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetAllocation> getAllocationsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnAsset(int allocationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRequest addServiceRequest(ServiceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRequest updateServiceRequestStatus(int requestId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceRequest> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceRequest> getAllRequestsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceRequest> getAllRequestsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceRequest> getAllRequestsByIssueType(String issueType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditRequest addAuditRequest(int userId, int assetNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditRequest> getAuditRequestsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditRequest> getAuditRequestsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditRequest> getAllAuditRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditRequest updateAuditRequestStatus(int auditId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
