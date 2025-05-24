package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.repositories.IAssetRepository;

@Service
public class IAssetManagementServiceImp implements IAssetManagementService {

	@Autowired
	IAssetRepository assetRepo;
	
	@Override
	public Asset addAsset(Asset asset) {
		
		return assetRepo.save(asset);
	}

	@Override
	public Asset getAssetByNo(int assetNo) {
		
		return assetRepo.findById(assetNo).orElse(null);
	}

	@Override
	public List<Asset> getAllAssets() {
		
		return assetRepo.findAll();
	}

	@Override
	public List<Asset> getAssetsByCategory(String category) {
		
		return assetRepo.findAllByCategory(category);
	}

	@Override
	public Asset updateAsset(Asset asset) {
		
		return assetRepo.save(asset);
	}

	@Override
	public String deleteAsset(int assetNo) {
		
		assetRepo.deleteById(assetNo);
		return assetNo+" deleted successfully";
	}

	@Override
	public AssetAllocation allocateAssetToUser(int employeeId, int assetNo, LocalDate returnDate) {
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
	public List<AssetAllocation> getAllocationsByUserId(int employeeId) {
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
	public List<ServiceRequest> getAllRequestsByEmployeeId(int employeeId) {
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
	public AuditRequest addAuditRequest(int employeeId, int assetNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditRequest> getAuditRequestsByEmployeeId(int employeeId) {
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
	public AuditRequest updateAuditRequestStatus(int auditNo, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRequest addAssetRequest(int employeeId, int assetNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetRequest> getAssetRequestsByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetRequest> getAssetRequestsByRequestId(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetRequest> getAssetRequestsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetRequest> getAllAssetRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRequest updateAssetRequestStatus(int auditNo, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditRequest> getAuditRequestsByRequestId(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	
   

}
