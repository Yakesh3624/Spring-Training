package com.hexaware.AdminMicrocontroller.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.AdminMicrocontroller.dto.AdminDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetAllocationDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.AuditRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.CredentialDTO;
import com.hexaware.AdminMicrocontroller.dto.ServiceRequestDTO;
import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.entities.Credential;


public interface IAdminService {
	
	AdminDTO addAdmin(Admin user);
	AdminDTO updateAdmin(Admin user) ;
	String deleteAdmin(int userId) ;
	AdminDTO getAdminById(int userId) ;
	List<AdminDTO> getAllAdmins();
	
	CredentialDTO addCredential(Credential credential);
	int updatePassword(String userName, String password);
	String deleteCredential(int userId);
	CredentialDTO getCredentialByAdminId(int userId);
	CredentialDTO getCredentialByUserName(String userName);
	List<CredentialDTO> getAllCredentials();
	CredentialDTO authenticate(String userName, String password);
	
	AssetDTO addAsset(AssetDTO asset);
	AssetDTO getAssetByNo(int assetNo);
	List<AssetDTO> getAllAssets();
	List<AssetDTO> getAssetsByCategory(String category);
	AssetDTO updateAsset(AssetDTO asset);
	String deleteAsset(int assetNo);
	
	AssetAllocationDTO allocateAssetToUser(int employeeId, int assetNo, LocalDate returnDate);
	AssetAllocationDTO getAllocationById(int allocationId);
	List<AssetAllocationDTO> getAllAllocations();
	List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId);
	String returnAsset(int allocationId);
	
	ServiceRequestDTO addServiceRequest(ServiceRequestDTO request);
	ServiceRequestDTO updateServiceRequestStatus(int requestId, String status);
	List<ServiceRequestDTO> getAllRequests();
	List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId);
	List<ServiceRequestDTO> getAllRequestsByStatus(String status);
	List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType);
	
	AuditRequestDTO addAuditRequest(int userId, int assetNo);
	List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId);
	List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId);
	List<AuditRequestDTO> getAuditRequestsByStatus(String status);
	List<AuditRequestDTO> getAllAuditRequests();
	AuditRequestDTO updateAuditRequestStatus(int auditNo, String status);
	
	AssetRequestDTO addAssetRequest(int employeeId, int assetNo);
	List<AssetRequestDTO> getAssetRequestsByStatus(String status);
	List<AssetRequestDTO> getAllAssetRequests();
	AssetRequestDTO updateAssetRequestStatus(int auditNo, String status);
	List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId);
	List<AssetRequestDTO> getAssetRequestsByRequestId(int requestId);
	AssetAllocationDTO grantAsset(int userId, int assetNo, LocalDate returnDate);
	
	
}
