package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetAllocationDTO;
import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.dto.AuditRequestDTO;
import com.hexaware.assetmanagement.dto.ServiceRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.repositories.IAssetAllocationRepository;
import com.hexaware.assetmanagement.repositories.IAssetRepository;
import com.hexaware.assetmanagement.repositories.IAssetRequestRepository;
import com.hexaware.assetmanagement.repositories.IAuditRequestRepository;
import com.hexaware.assetmanagement.repositories.IServiceRequestRepository;

@Service
public class IAssetManagementServiceImp implements IAssetManagementService {


	@Autowired
	IAssetRepository assetRepo;
	@Autowired
	IAssetAllocationRepository assetAllocationRepo;
	@Autowired
	IServiceRequestRepository serviceRequestRepo;
	@Autowired
	IAuditRequestRepository auditRequestRepo;
	@Autowired
	IAssetRequestRepository assetRequestRepo;

	
	@Override
	public AssetDTO addAsset(Asset asset) {

		assetRepo.save(asset);
		return asset2dto(asset);
	}

	@Override
	public AssetDTO getAssetByNo(int assetNo) {

		Asset asset = assetRepo.findById(assetNo).orElse(null);
		return asset2dto(asset);
	}

	@Override
	public List<AssetDTO> getAllAssets() {

		List<Asset> assetList = assetRepo.findAll();
		return asset2dtolist(assetList);
	}

	@Override
	public List<AssetDTO> getAssetsByCategory(String category) {

		List<Asset> assetList = assetRepo.findAllByCategory(category);
		return asset2dtolist(assetList);
	}

	@Override
	public AssetDTO updateAsset(Asset asset) {

		assetRepo.save(asset);
		return asset2dto(asset);
	}

	@Override
	public String deleteAsset(int assetNo) {

		assetRepo.deleteById(assetNo);
		return assetNo + " deleted successfully";
	}

	@Override
	public AssetAllocationDTO allocateAssetToEmployee(int employeeId, int assetNo, LocalDate returnDate) {

		AssetAllocation assetAllocation = assetAllocationRepo.allocateAssetToEmployee(employeeId, assetNo, returnDate);
		return assetAllocation2dto(assetAllocation);
	}

	@Override
	public AssetAllocationDTO getAllocationById(int allocationId) {

		AssetAllocation assetAllocation = assetAllocationRepo.findById(allocationId).orElse(null);
		return assetAllocation2dto(assetAllocation);
	}

	@Override
	public List<AssetAllocationDTO> getAllAllocations() {

		List<AssetAllocation> assetAllocation = assetAllocationRepo.findAll();
		return assetAllocation2dtolist(assetAllocation);
	}

	@Override
	public List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId) {

		List<AssetAllocation> assetAllocation = assetAllocationRepo.findAllByEmployee_EmployeeId(employeeId);
		return assetAllocation2dtolist(assetAllocation);
	}

	@Override
	public int returnAsset(int allocationId) {

		return assetAllocationRepo.returnAsset(allocationId);
	}

	@Override
	public ServiceRequestDTO addServiceRequest(ServiceRequest request) {

		serviceRequestRepo.save(request);
		return serviceRequest2dto(request);
	}

	@Override
	public int updateServiceRequestStatus(int requestId, String status) {

		return serviceRequestRepo.updateServiceRequestStatus(requestId, status);
		
	}

	@Override
	public List<ServiceRequestDTO> getAllRequests() {

		List<ServiceRequest> serviceRequest =  serviceRequestRepo.findAll();
		return serviceRequest2dtolist(serviceRequest);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId) {

		List<ServiceRequest> serviceRequest =  serviceRequestRepo.findAllByEmployee_EmployeeId(employeeId);
		return serviceRequest2dtolist(serviceRequest);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByStatus(String status) {

		List<ServiceRequest> serviceRequest =  serviceRequestRepo.findAllByStatus(status);
		return serviceRequest2dtolist(serviceRequest);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType) {

		List<ServiceRequest> serviceRequest =  serviceRequestRepo.findAllByIssueType(issueType);
		return serviceRequest2dtolist(serviceRequest);
	}

	@Override
	public AuditRequestDTO addAuditRequest(int employeeId, int assetNo) {

		AuditRequest auditRequest = auditRequestRepo.addAuditRequest(employeeId, assetNo);
		return auditRequest2dto(auditRequest);
	}

	@Override
	public List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId) {

		List<AuditRequest> auditRequest = auditRequestRepo.findAllByEmployee_EmployeeId(employeeId);
		return auditRequest2dtolist(auditRequest);
	}

	@Override
	public List<AuditRequestDTO> getAuditRequestsByStatus(String status) {

		List<AuditRequest> auditRequest = auditRequestRepo.findAllByStatus(status);
		return auditRequest2dtolist(auditRequest);
	}

	@Override
	public List<AuditRequestDTO> getAllAuditRequests() {

		List<AuditRequest> auditRequest = auditRequestRepo.findAll();
		return auditRequest2dtolist(auditRequest);
	}

	@Override
	public int updateAuditRequestStatus(int requestId, String status) {

		return auditRequestRepo.updateAuditRequestStatus(requestId, status);
		
	}


	@Override
	public List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId) {

		List<AuditRequest> auditRequest = auditRequestRepo.findAllByRequestId(requestId);
		return auditRequest2dtolist(auditRequest);
	}

	@Override
	public int addAssetRequest(int employeeId, int assetNo) {

		return assetRequestRepo.addAssetRequest(employeeId, assetNo);
		
	}
	
	@Override
	public List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId) {

		List<AssetRequest> assetRequest = assetRequestRepo.findAllByEmployee_EmployeeId(employeeId);
		return assetRequest2dtolist(assetRequest);
	}

	@Override
	public List<AssetRequestDTO> getAssetRequestsByRequestId(int requestId) {

		List<AssetRequest> assetRequest = assetRequestRepo.findAllByRequestId(requestId);
		return assetRequest2dtolist(assetRequest);
	}

	@Override
	public List<AssetRequestDTO> getAssetRequestsByStatus(String status) {

		List<AssetRequest> assetRequest = assetRequestRepo.findAllByStatus(status);
		return assetRequest2dtolist(assetRequest);
	}

	@Override
	public List<AssetRequestDTO> getAllAssetRequests() {

		List<AssetRequest> assetRequest = assetRequestRepo.findAll();
		return assetRequest2dtolist(assetRequest);
	}

	@Override
	public int updateAssetRequestStatus(int assetNo, String status) {

		return assetRequestRepo.updateAssetStatus(assetNo, status);
		
	}

	public static AssetAllocationDTO assetAllocation2dto(AssetAllocation assetAllocation) {
		AssetAllocationDTO assetAllocationDto = new AssetAllocationDTO();
		assetAllocationDto.setAllocationId(assetAllocation.getAllocationId());
		assetAllocationDto.setAssetNo(assetAllocation.getAsset().getAssetNo());
		assetAllocationDto.setEmployeeId(assetAllocation.getEmployee().getEmployeeId());
		assetAllocationDto.setAllocationDate(assetAllocation.getAllocationDate());
		assetAllocationDto.setReturnDate(assetAllocation.getReturnDate());

		return assetAllocationDto;
	}

	public static List<AssetAllocationDTO> assetAllocation2dtolist(List<AssetAllocation> assetAllocationList) {
		List<AssetAllocationDTO> assetAllocationListDto = new ArrayList<AssetAllocationDTO>();
		for (AssetAllocation assetAllocation : assetAllocationList) {
			AssetAllocationDTO assetAllocationDto = new AssetAllocationDTO();
			assetAllocationDto.setAllocationId(assetAllocation.getAllocationId());
			assetAllocationDto.setAssetNo(assetAllocation.getAsset().getAssetNo());
			assetAllocationDto.setEmployeeId(assetAllocation.getEmployee().getEmployeeId());
			assetAllocationDto.setAllocationDate(assetAllocation.getAllocationDate());
			assetAllocationDto.setReturnDate(assetAllocation.getReturnDate());

			assetAllocationListDto.add(assetAllocationDto);
		}
		return assetAllocationListDto;
	}

	public static AssetDTO asset2dto(Asset asset) {
		AssetDTO assetDto = new AssetDTO();
		assetDto.setAssetNo(asset.getAssetNo());
		assetDto.setAssetName(asset.getAssetName());
		assetDto.setAssetModel(asset.getAssetModel());
		assetDto.setAssetCategory(asset.getAssetCategory());
		assetDto.setAssetValue(asset.getAssetValue());
		assetDto.setManufacturingDate(asset.getManufacturingDate());
		assetDto.setExpiryDate(asset.getExpiryDate());
		assetDto.setAvailability(asset.getAvailability());

		return assetDto;
	}

	public static List<AssetDTO> asset2dtolist(List<Asset> assetList) {
		List<AssetDTO> assetListDto = new ArrayList<AssetDTO>();
		for (Asset asset : assetList) {
			AssetDTO assetDto = new AssetDTO();
			assetDto.setAssetNo(asset.getAssetNo());
			assetDto.setAssetName(asset.getAssetName());
			assetDto.setAssetModel(asset.getAssetModel());
			assetDto.setAssetCategory(asset.getAssetCategory());
			assetDto.setAssetValue(asset.getAssetValue());
			assetDto.setManufacturingDate(asset.getManufacturingDate());
			assetDto.setExpiryDate(asset.getExpiryDate());
			assetDto.setAvailability(asset.getAvailability());

			assetListDto.add(assetDto);
		}
		return assetListDto;
	}
	
	public static ServiceRequestDTO serviceRequest2dto(ServiceRequest serviceRequest) {
		ServiceRequestDTO serviceRequestDto = new ServiceRequestDTO();
		serviceRequestDto.setAssetNo(serviceRequest.getAsset().getAssetNo());
		serviceRequestDto.setEmployeeId(serviceRequest.getEmployee().getEmployeeId());
		serviceRequestDto.setRequestId(serviceRequest.getRequestId());
		serviceRequestDto.setAssetDscription(serviceRequest.getAssetDscription());
		serviceRequestDto.setIssueType(serviceRequest.getIssueType());
		serviceRequestDto.setRequestedAt(serviceRequest.getRequestedAt());
		serviceRequestDto.setRequestStatus(serviceRequest.getRequestStatus());
		
		return serviceRequestDto;
	}

	public static List<ServiceRequestDTO> serviceRequest2dtolist(List<ServiceRequest> serviceRequestList) {
		List<ServiceRequestDTO> serviceRequestListDto = new ArrayList<ServiceRequestDTO>();
		for (ServiceRequest serviceRequest : serviceRequestList) {
			ServiceRequestDTO serviceRequestDto = new ServiceRequestDTO();
			serviceRequestDto.setAssetNo(serviceRequest.getAsset().getAssetNo());
			serviceRequestDto.setEmployeeId(serviceRequest.getEmployee().getEmployeeId());
			serviceRequestDto.setRequestId(serviceRequest.getRequestId());
			serviceRequestDto.setAssetDscription(serviceRequest.getAssetDscription());
			serviceRequestDto.setIssueType(serviceRequest.getIssueType());
			serviceRequestDto.setRequestedAt(serviceRequest.getRequestedAt());
			serviceRequestDto.setRequestStatus(serviceRequest.getRequestStatus());

			serviceRequestListDto.add(serviceRequestDto);
		}
		return serviceRequestListDto;
	}
	
	public static AuditRequestDTO auditRequest2dto(AuditRequest auditRequest) {
		AuditRequestDTO auditRequestDto = new AuditRequestDTO();
		auditRequestDto.setAssetNo(auditRequest.getAsset().getAssetNo());
		auditRequestDto.setAuditId(auditRequest.getAuditId());
		auditRequestDto.setEmployeeId(auditRequest.getEmployee().getEmployeeId());
		auditRequestDto.setRequestedAt(auditRequest.getRequestedAt());
		auditRequestDto.setRequestStatus(auditRequest.getRequestStatus());
		
		
		return auditRequestDto;
	}

	public static List<AuditRequestDTO> auditRequest2dtolist(List<AuditRequest> auditRequestList) {
		List<AuditRequestDTO> auditRequestListDto = new ArrayList<AuditRequestDTO>();
		for (AuditRequest auditRequest : auditRequestList) {
			AuditRequestDTO auditRequestDto = new AuditRequestDTO();
			auditRequestDto.setAssetNo(auditRequest.getAsset().getAssetNo());
			auditRequestDto.setAuditId(auditRequest.getAuditId());
			auditRequestDto.setEmployeeId(auditRequest.getEmployee().getEmployeeId());
			auditRequestDto.setRequestedAt(auditRequest.getRequestedAt());
			auditRequestDto.setRequestStatus(auditRequest.getRequestStatus());

			auditRequestListDto.add(auditRequestDto);
		}
		return auditRequestListDto;
	}
	
	public static AssetRequestDTO assetRequest2dto(AssetRequest assetRequest) {
		AssetRequestDTO assetRequestDto = new AssetRequestDTO();
		assetRequestDto.setAssetNo(assetRequest.getAsset().getAssetNo());
		assetRequestDto.setEmployeeId(assetRequest.getEmployee().getEmployeeId());
		assetRequestDto.setRequestedAt(assetRequest.getRequestedAt());
		assetRequestDto.setRequestStatus(assetRequest.getRequestStatus());
		assetRequestDto.setRequetId(assetRequest.getRequestId());
		
		return assetRequestDto;
	}

	public static List<AssetRequestDTO> assetRequest2dtolist(List<AssetRequest> assetRequestList) {
		List<AssetRequestDTO> assetRequestListDto = new ArrayList<AssetRequestDTO>();
		for (AssetRequest assetRequest : assetRequestList) {
			AssetRequestDTO assetRequestDto = new AssetRequestDTO();
			assetRequestDto.setAssetNo(assetRequest.getAsset().getAssetNo());
			assetRequestDto.setEmployeeId(assetRequest.getEmployee().getEmployeeId());
			assetRequestDto.setRequestedAt(assetRequest.getRequestedAt());
			assetRequestDto.setRequestStatus(assetRequest.getRequestStatus());
			assetRequestDto.setRequetId(assetRequest.getRequestId());

			assetRequestListDto.add(assetRequestDto);
		}
		return assetRequestListDto;
	}

}
