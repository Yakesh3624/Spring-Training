package com.hexaware.assetmanagement.dto;

import java.sql.Timestamp;


public class AssetRequestDTO {
	
	
	private int requetId;
	private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	private String requestStatus = "PENDING";
	int assetNo;
	int employeeId;

	
	
	public AssetRequestDTO() {
		super();
	}



	public AssetRequestDTO(int requetId, Timestamp requestedAt, String requestStatus, int assetNo, int employeeId) {
		super();
		this.requetId = requetId;
		this.requestedAt = requestedAt;
		this.requestStatus = requestStatus;
		this.assetNo = assetNo;
		this.employeeId = employeeId;
	}



	public int getRequetId() {
		return requetId;
	}



	public void setRequetId(int requetId) {
		this.requetId = requetId;
	}



	public Timestamp getRequestedAt() {
		return requestedAt;
	}



	public void setRequestedAt(Timestamp requestedAt) {
		this.requestedAt = requestedAt;
	}



	public String getRequestStatus() {
		return requestStatus;
	}



	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}



	public int getAssetNo() {
		return assetNo;
	}



	public void setAssetNo(int assetNo) {
		this.assetNo = assetNo;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	@Override
	public String toString() {
		return "AssetRequestDTO [requetId=" + requetId + ", requestedAt=" + requestedAt + ", requestStatus="
				+ requestStatus + ", assetNo=" + assetNo + ", employeeId=" + employeeId + "]";
	}

	
    
}
