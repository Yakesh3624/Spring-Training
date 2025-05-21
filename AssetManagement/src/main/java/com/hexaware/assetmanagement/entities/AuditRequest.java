package com.hexaware.assetmanagement.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="audit_request")
public class AuditRequest {
	
	@Id
	private int auditId;
	
	@Column(nullable = false,name = "requestedAt")
    private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	@Column(nullable = false,name = "status")
    private String requestStatus = "PENDING";
	
	@ManyToOne
	@JoinColumn(name="assetNo")
	Asset asset;
	
	@ManyToOne
	@JoinColumn(name="userId")
	Users user;

	public AuditRequest(int auditId, Timestamp requestedAt, String requestStatus, Asset asset, Users user) {
		super();
		this.auditId = auditId;
		this.requestedAt = requestedAt;
		this.requestStatus = requestStatus;
		this.asset = asset;
		this.user = user;
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

	@Override
	public String toString() {
		return "AuditRequest [auditId=" + auditId + ", requestedAt=" + requestedAt + ", requestStatus=" + requestStatus
				+ ", asset=" + asset + ", user=" + user + "]";
	}
	
	
    
}
