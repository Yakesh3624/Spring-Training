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
	private int requestId;
	
	@Column(nullable = false,name = "requestedAt")
    private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	@Column(nullable = false,name = "status")
    private String status = "PENDING";
	
	@ManyToOne
	@JoinColumn(name="assetNo")
	Asset asset;
	
	@ManyToOne
	@JoinColumn(name="userId")
	Employee employee;

	public AuditRequest() {
		super();
	}

	public AuditRequest(int auditId, Timestamp requestedAt, String status, Asset asset, Employee employee) {
		super();
		this.requestId = auditId;
		this.requestedAt = requestedAt;
		this.status = status;
		this.asset = asset;
		this.employee = employee;
	}

	public int getAuditId() {
		return requestId;
	}

	public void setAuditId(int auditId) {
		this.requestId = auditId;
	}

	public Timestamp getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(Timestamp requestedAt) {
		this.requestedAt = requestedAt;
	}

	public String getRequestStatus() {
		return status;
	}

	public void setRequestStatus(String status) {
		this.status = status;
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
		return "AuditRequest [auditId=" + requestId + ", requestedAt=" + requestedAt + ", status=" + status + ", asset="
				+ asset + ", employee=" + employee + "]";
	}
	
	

	
    
}
