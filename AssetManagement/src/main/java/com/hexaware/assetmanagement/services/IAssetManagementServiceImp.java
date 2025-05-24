package com.hexaware.assetmanagement.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.ServiceRequest;

@Service
public class IAssetManagementServiceImp implements IAssetManagementService {

    

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
