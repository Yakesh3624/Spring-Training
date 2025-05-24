package com.hexaware.assetmanagement.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="service_request")
public class ServiceRequest {
	
	@Id
	private int requestId;
	@Column(nullable = false,name = "description")
    private String assetDscription;
	@Column(nullable = false,name = "issue_type")
    private String issueType;
	@Column(nullable = false,name = "status")
    private String requestStatus = "PENDING";
	@Column(nullable = false)
    private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="assetNo")
	Asset asset;
	
	@ManyToOne
	@JoinColumn(name="userId")
	Employee employee;

	public ServiceRequest() {
		super();
	}

	public ServiceRequest(int requestId, String assetDscription, String issueType, String requestStatus,
			Timestamp requestedAt, Asset asset, Employee employee) {
		super();
		this.requestId = requestId;
		this.assetDscription = assetDscription;
		this.issueType = issueType;
		this.requestStatus = requestStatus;
		this.requestedAt = requestedAt;
		this.asset = asset;
		this.employee = employee;
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

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ServiceRequest [requestId=" + requestId + ", assetDscription=" + assetDscription + ", issueType="
				+ issueType + ", requestStatus=" + requestStatus + ", requestedAt=" + requestedAt + ", asset=" + asset
				+ ", employee=" + employee + "]";
	}
	
	

	
}
