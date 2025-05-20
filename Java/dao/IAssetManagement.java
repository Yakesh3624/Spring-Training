package com.yakesh.AssetManagement.dao;

import java.util.List;

import com.yakesh.AssetManagement.Entity.Asset;
import com.yakesh.AssetManagement.Entity.AssetAllocation;
import com.yakesh.AssetManagement.Entity.AuditRequest;
import com.yakesh.AssetManagement.Entity.Credential;
import com.yakesh.AssetManagement.Entity.ServiceRequest;
import com.yakesh.AssetManagement.Entity.Users;

public interface IAssetManagement {
	
	void addUser(Users user);
    void updateUser(Users user);
    void deleteUser(int userId);
    Users getUserById(int userId);
    List<Users> getAllUsers();
    
    void addCredential(Credential credential);
    Credential getCredentialByUsername(String username);
    void updatePassword(int userId, String newPassword);
    
    void addAsset(Asset asset);
    void updateAsset(Asset asset);
    void deleteAsset(int assetNo);
    Asset getAssetById(int assetNo);
    List<Asset> getAllAssets();
    
    void allocateAsset(AssetAllocation allocation);
    List<AssetAllocation> getAllocationsByUserId(int userId);
    void returnAsset(int allocationId);
    
    void raiseServiceRequest(ServiceRequest request);
    List<ServiceRequest> getRequestsByUserId(int userId);
    void updateServiceRequestStatus(int requestId, String status);

   
    void raiseAuditRequest(AuditRequest request);
    List<AuditRequest> getAuditRequestsByUserId(int userId);
    void updateAuditRequestStatus(int auditId, String status);

}
