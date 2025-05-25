package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.assetmanagement.dto.AssetAllocationDTO;
import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.dto.AuditRequestDTO;
import com.hexaware.assetmanagement.dto.ServiceRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.ServiceRequest;


public interface IAssetManagementService {
	
	
	AssetDTO addAsset(Asset asset);
	AssetDTO getAssetByNo(int assetNo);
	List<AssetDTO> getAllAssets();
	List<AssetDTO> getAssetsByCategory(String category);
	AssetDTO updateAsset(Asset asset);
	String deleteAsset(int assetNo);
	
	AssetAllocationDTO allocateAssetToEmployee(int employeeId, int assetNo, LocalDate returnDate);
	AssetAllocationDTO getAllocationById(int allocationId);
	List<AssetAllocationDTO> getAllAllocations();
	List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId);
	int returnAsset(int allocationId);
	
	ServiceRequestDTO addServiceRequest(ServiceRequest request);
	int updateServiceRequestStatus(int requestId, String status);
	List<ServiceRequestDTO> getAllRequests();
	List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId);
	List<ServiceRequestDTO> getAllRequestsByStatus(String status);
	List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType);
	
	AuditRequestDTO addAuditRequest(int employeeId, int assetNo);
	List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId);
	List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId);
	List<AuditRequestDTO> getAuditRequestsByStatus(String status);
	List<AuditRequestDTO> getAllAuditRequests();
	int updateAuditRequestStatus(int auditNo, String status);
	
	int addAssetRequest(int employeeId, int assetNo);
	List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId);
	List<AssetRequestDTO> getAssetRequestsByRequestId(int requestId);
	List<AssetRequestDTO> getAssetRequestsByStatus(String status);
	List<AssetRequestDTO> getAllAssetRequests();
	int updateAssetRequestStatus(int auditNo, String status);
}
