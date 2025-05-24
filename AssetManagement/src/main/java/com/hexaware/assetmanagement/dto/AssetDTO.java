package com.hexaware.assetmanagement.dto;

import java.time.LocalDate;

public class AssetDTO {
	
	
	private int assetNo;
	private String assetName;
	private String assetCategory;
	private String assetModel;
	private LocalDate manufacturingDate;
	private LocalDate expiryDate;
	private double assetValue;
	private String availability;
	
	
	
	public AssetDTO() {
		super();
	}
	
	public AssetDTO(int assetNo, String assetName, String assetCategory, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, double assetValue,String availability) {
		super();
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
		this.availability = availability;
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Asset [assetNo=" + assetNo + ", assetName=" + assetName + ", assetCategory=" + assetCategory
				+ ", assetModel=" + assetModel + ", manufacturingDate=" + manufacturingDate + ", expiryDate="
				+ expiryDate + ", assetValue=" + assetValue + ", availability=" + availability + "]";
	}
	
	
	
	
	
	
    
    
	
}
