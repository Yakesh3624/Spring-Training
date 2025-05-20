package com.yakesh.AssetManagement.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AuditRequest {
	
	@Id
	private int auditId;
	@ManyToOne
    @JoinColumn(name = "assetNo", nullable = false)
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    private Timestamp requestAt = new Timestamp(System.currentTimeMillis());
    private String requestStatus = "PENDING";
	public AuditRequest(int auditId, Asset asset, Users user, Timestamp requestAt, String requestStatus) {
		super();
		this.auditId = auditId;
		this.asset = asset;
		this.user = user;
		this.requestAt = requestAt;
		this.requestStatus = requestStatus;
	}
	public AuditRequest(int auditId, Timestamp requestAt, String requestStatus) {
		super();
		this.auditId = auditId;
		this.requestAt = requestAt;
		this.requestStatus = requestStatus;
	}
	public AuditRequest() {
		super();
	}
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
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
	public Timestamp getRequestAt() {
		return requestAt;
	}
	public void setRequestAt(Timestamp requestAt) {
		this.requestAt = requestAt;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Override
	public String toString() {
		return "AuditRequest [auditId=" + auditId + ", asset=" + asset + ", user=" + user + ", requestAt=" + requestAt
				+ ", requestStatus=" + requestStatus + "]";
	}
    
    
}
