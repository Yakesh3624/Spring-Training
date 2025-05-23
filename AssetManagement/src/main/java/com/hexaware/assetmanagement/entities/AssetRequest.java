package com.hexaware.assetmanagement.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="asset_request")
public class AssetRequest {
	
	@Id
	private int requestId;
	
	@Column(nullable = false,name = "requestedAt")
    private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());
	@Column(nullable = false,name = "status")
    private String requestStatus = "PENDING";
	
	@ManyToOne
	@JoinColumn(name="assetNo")
	Asset asset;
	
	@ManyToOne
	@JoinColumn(name="userId")
	Employee employee;

	public AssetRequest() {
		super();
	}

	public AssetRequest(int requestId, Timestamp requestedAt, String requestStatus, Asset asset, Employee employee) {
		super();
		this.requestId = requestId;
		this.requestedAt = requestedAt;
		this.requestStatus = requestStatus;
		this.asset = asset;
		this.employee = employee;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AssetRequest [requestId=" + requestId + ", requestedAt=" + requestedAt + ", requestStatus="
				+ requestStatus + ", asset=" + asset + ", employee=" + employee + "]";
	}
	
	

}
