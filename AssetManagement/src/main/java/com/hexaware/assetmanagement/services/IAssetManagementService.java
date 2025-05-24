package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.ServiceRequest;


public interface IAssetManagementService {
	
	
	Asset addAsset(Asset asset);
	Asset getAssetByNo(int assetNo);
	List<Asset> getAllAssets();
	List<Asset> getAssetsByCategory(String category);
	Asset updateAsset(Asset asset);
	String deleteAsset(int assetNo);
	
	AssetAllocation allocateAssetToUser(int employeeId, int assetNo, LocalDate returnDate);
	AssetAllocation getAllocationById(int allocationId);
	List<AssetAllocation> getAllAllocations();
	List<AssetAllocation> getAllocationsByUserId(int employeeId);
	String returnAsset(int allocationId);
	
	ServiceRequest addServiceRequest(ServiceRequest request);
	ServiceRequest updateServiceRequestStatus(int requestId, String status);
	List<ServiceRequest> getAllRequests();
	List<ServiceRequest> getAllRequestsByEmployeeId(int employeeId);
	List<ServiceRequest> getAllRequestsByStatus(String status);
	List<ServiceRequest> getAllRequestsByIssueType(String issueType);
	
	AuditRequest addAuditRequest(int employeeId, int assetNo);
	List<AuditRequest> getAuditRequestsByEmployeeId(int employeeId);
	List<AuditRequest> getAuditRequestsByRequestId(int requestId);
	List<AuditRequest> getAuditRequestsByStatus(String status);
	List<AuditRequest> getAllAuditRequests();
	AuditRequest updateAuditRequestStatus(int auditNo, String status);
	
	AssetRequest addAssetRequest(int employeeId, int assetNo);
	List<AssetRequest> getAssetRequestsByEmployeeId(int employeeId);
	List<AssetRequest> getAssetRequestsByRequestId(int requestId);
	List<AssetRequest> getAssetRequestsByStatus(String status);
	List<AssetRequest> getAllAssetRequests();
	AssetRequest updateAssetRequestStatus(int auditNo, String status);
}
