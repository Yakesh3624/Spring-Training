package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.Credential;
import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.entities.Users;


public interface IAssetManagementService {
	
	Users addUser(Users user);
	Users getUserById(int userId);
	List<Users> getAllUsers();
	Users updateUser(Users user);
	String deleteUser(int userId);
	
	Credential addCredential(Credential credential);
	Credential getCredentialByUserId(int userId);
	Credential authenticate(String userName, String password);
	int updatePassword(String userName, String password);
	String deleteCredential(int userId);
	
	Asset addAsset(Asset asset);
	Asset getAssetByNo(int assetNo);
	List<Asset> getAllAssets();
	List<Asset> getAssetsByCategory(String category);
	Asset updateAsset(Asset asset);
	String deleteAsset(int assetNo);
	
	AssetAllocation allocateAssetToUser(int userId, int assetNo, LocalDate returnDate);
	AssetAllocation getAllocationById(int allocationId);
	List<AssetAllocation> getAllAllocations();
	List<AssetAllocation> getAllocationsByUserId(int userId);
	String returnAsset(int allocationId);
	
	ServiceRequest addServiceRequest(ServiceRequest request);
	ServiceRequest updateServiceRequestStatus(int requestId, String status);
	List<ServiceRequest> getAllRequests();
	List<ServiceRequest> getAllRequestsByUserId(int userId);
	List<ServiceRequest> getAllRequestsByStatus(String status);
	List<ServiceRequest> getAllRequestsByIssueType(String issueType);
	
	AuditRequest addAuditRequest(int userId, int assetNo);
	List<AuditRequest> getAuditRequestsByUserId(int userId);
	List<AuditRequest> getAuditRequestsByStatus(String status);
	List<AuditRequest> getAllAuditRequests();
	AuditRequest updateAuditRequestStatus(int auditNo, String status);
}
