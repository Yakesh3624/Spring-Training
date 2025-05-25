package com.hexaware.assetmanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asset {
	
	@Id
	private int assetNo;
	@Column(nullable = false,name = "asset_name")
    private String assetName;
	@Column(nullable = false,name = "category")
    private String category;
	@Column(nullable = false,name = "model")
    private String assetModel;
	@Column(nullable = false)
    private LocalDate manufacturingDate;
	@Column(nullable = false)
    private LocalDate expiryDate;
	@Column(nullable = false)
    private double assetValue;
	@Column(nullable = false)
    private String availability="available";
	
	
	
	public Asset() {
		super();
	}
	
	public Asset(int assetNo, String assetName, String category, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, double assetValue,String availability) {
		super();
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.category = category;
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
		return category;
	}
	public void setAssetCategory(String assetCategory) {
		this.category = assetCategory;
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
		return "Asset [assetNo=" + assetNo + ", assetName=" + assetName + ", assetCategory=" + category
				+ ", assetModel=" + assetModel + ", manufacturingDate=" + manufacturingDate + ", expiryDate="
				+ expiryDate + ", assetValue=" + assetValue + ", availability=" + availability + "]";
	}
	
	
	
	
	
	
    
    
	
}
