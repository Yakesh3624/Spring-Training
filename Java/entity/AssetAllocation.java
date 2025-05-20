package com.yakesh.AssetManagement.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssetAllocation {
	
	
	private int allocationId;
	@ManyToOne
    @JoinColumn(name = "assetNo")
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    private LocalDate allocationDate = LocalDate.now();
    private LocalDate returnDate;
	public AssetAllocation(int allocationId, Asset asset, Users user, LocalDate allocationDate, LocalDate returnDate) {
		super();
		this.allocationId = allocationId;
		this.asset = asset;
		this.user = user;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
	}
	public AssetAllocation(int allocationId, LocalDate allocationDate, LocalDate returnDate) {
		super();
		this.allocationId = allocationId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
	}
	public AssetAllocation() {
		super();
	}
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
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
	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", asset=" + asset + ", user=" + user
				+ ", allocationDate=" + allocationDate + ", returnDate=" + returnDate + "]";
	}
    
    
}
