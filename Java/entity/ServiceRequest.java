package com.yakesh.AssetManagement.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceRequest {
	
	@Id
	private int requestId;
	
	@ManyToOne
    @JoinColumn(name = "assetNo", nullable = false)
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    private String assetDscription;
    private String issueType;
    private String requestStatus = "PENDING";
    private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	public ServiceRequest(int requestId, Asset asset, Users user, String assetDscription, String issueType,
			String requestStatus, Timestamp requestedAt) {
		super();
		this.requestId = requestId;
		this.asset = asset;
		this.user = user;
		this.assetDscription = assetDscription;
		this.issueType = issueType;
		this.requestStatus = requestStatus;
		this.requestedAt = requestedAt;
	}
	public ServiceRequest(int requestId, String assetDscription, String issueType, String requestStatus,
			Timestamp requestedAt) {
		super();
		this.requestId = requestId;
		this.assetDscription = assetDscription;
		this.issueType = issueType;
		this.requestStatus = requestStatus;
		this.requestedAt = requestedAt;
	}
	public ServiceRequest() {
		super();
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	@Override
	public String toString() {
		return "ServiceRequest [requestId=" + requestId + ", asset=" + asset + ", user=" + user + ", assetDscription="
				+ assetDscription + ", issueType=" + issueType + ", requestStatus=" + requestStatus + ", requestedAt="
				+ requestedAt + "]";
	}
    
    
}
