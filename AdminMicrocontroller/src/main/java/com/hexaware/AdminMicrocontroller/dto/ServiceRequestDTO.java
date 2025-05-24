package com.hexaware.AdminMicrocontroller.dto;

import java.sql.Timestamp;


public class ServiceRequestDTO {
	
	
	private int requestId;
	private String assetDscription;
	private String issueType;
	private String requestStatus = "PENDING";
	private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	int assetNo;
	int employeeId;
	
	

	public ServiceRequestDTO() {
		super();
	}

	public ServiceRequestDTO(int requestId, String assetDscription, String issueType, String requestStatus,
			Timestamp requestedAt, int assetNo, int employeeId) {
		super();
		this.requestId = requestId;
		this.assetDscription = assetDscription;
		this.issueType = issueType;
		this.requestStatus = requestStatus;
		this.requestedAt = requestedAt;
		this.assetNo = assetNo;
		this.employeeId = employeeId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getAssetDscription() {
		return assetDscription;
	}

	public void setAssetDscription(String assetDscription) {
		this.assetDscription = assetDscription;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Timestamp getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(Timestamp requestedAt) {
		this.requestedAt = requestedAt;
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
		return "ServiceRequestDTO [requestId=" + requestId + ", assetDscription=" + assetDscription + ", issueType="
				+ issueType + ", requestStatus=" + requestStatus + ", requestedAt=" + requestedAt + ", assetNo="
				+ assetNo + ", employeeId=" + employeeId + "]";
	}

	
	
}
