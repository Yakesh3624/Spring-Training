package com.hexaware.assetmanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="asset_allocation")
public class AssetAllocation {
	
	@Id()
	private int allocationId;
	@Column(nullable = false,name = "allocation_date")
    private LocalDate allocationDate = LocalDate.now();
	@Column(nullable = false,name = "retun_date")
    private LocalDate returnDate;
	
	@ManyToOne
	@JoinColumn(name="assetNo")
	Asset asset;
	
	@ManyToOne
	@JoinColumn(name="userID")
	Users user;

	public AssetAllocation(int allocationId, LocalDate allocationDate, LocalDate returnDate, Asset asset, Users user) {
		super();
		this.allocationId = allocationId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
		this.asset = asset;
		this.user = user;
	}

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public LocalDate getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(LocalDate allocationDate) {
		this.allocationDate = allocationDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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
		return "AssetAllocation [allocationId=" + allocationId + ", allocationDate=" + allocationDate + ", returnDate="
				+ returnDate + ", asset=" + asset + ", user=" + user + "]";
	}
	
	
	
    
}
