package com.hexaware.assetmanagement.dto;

import java.sql.Timestamp;


public class AuditRequestDTO {
	
	
	private int auditId;
	private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	private String requestStatus = "PENDING";
	int assetNo;
	int employeeId;

	
	
	public AuditRequestDTO() {
		super();
	}

	public AuditRequestDTO(int auditId, Timestamp requestedAt, String requestStatus, int assetNo, int employeeId) {
		super();
		this.auditId = auditId;
		this.requestedAt = requestedAt;
		this.requestStatus = requestStatus;
		this.assetNo = assetNo;
		this.employeeId = employeeId;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
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
		return "AuditRequestDTO [auditId=" + auditId + ", requestedAt=" + requestedAt + ", requestStatus="
				+ requestStatus + ", assetNo=" + assetNo + ", employeeId=" + employeeId + "]";
	}

	
	
	
    
}
