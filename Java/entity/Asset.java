package com.yakesh.AssetManagement.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Asset {
	
	@Id
	private int assetNo;
    private String assetName;
    private String assetCategory;
    private String assetModel;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private double assetValue;
    
    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<AssetAllocation> allocations;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<AuditRequest> auditRequests;

	public Asset(int assetNo, String assetName, String assetCategory, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, double assetValue, List<AssetAllocation> allocations,
			List<ServiceRequest> serviceRequests, List<AuditRequest> auditRequests) {
		super();
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
		this.allocations = allocations;
		this.serviceRequests = serviceRequests;
		this.auditRequests = auditRequests;
	}

	public Asset(int assetNo, String assetName, String assetCategory, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, double assetValue) {
		super();
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
	}

	public Asset() {
		super();
	}

	public int getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(int assetNo) {
		this.assetNo = assetNo;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}

	public List<AssetAllocation> getAllocations() {
		return allocations;
	}

	public void setAllocations(List<AssetAllocation> allocations) {
		this.allocations = allocations;
	}

	public List<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public List<AuditRequest> getAuditRequests() {
		return auditRequests;
	}

	public void setAuditRequests(List<AuditRequest> auditRequests) {
		this.auditRequests = auditRequests;
	}

	@Override
	public String toString() {
		return "Asset [assetNo=" + assetNo + ", assetName=" + assetName + ", assetCategory=" + assetCategory
				+ ", assetModel=" + assetModel + ", manufacturingDate=" + manufacturingDate + ", expiryDate="
				+ expiryDate + ", assetValue=" + assetValue + ", allocations=" + allocations + ", serviceRequests="
				+ serviceRequests + ", auditRequests=" + auditRequests + "]";
	}
    
    
	
}
