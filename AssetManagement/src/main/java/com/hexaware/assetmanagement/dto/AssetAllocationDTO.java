package com.hexaware.assetmanagement.dto;

import java.time.LocalDate;


public class AssetAllocationDTO {
	
	
	private int allocationId;
	private LocalDate allocationDate = LocalDate.now();
	private LocalDate returnDate;
	int assetNo;
	int employeeId;

	
	public AssetAllocationDTO()
	{
		super();
	}
	public AssetAllocationDTO(int allocationId, LocalDate allocationDate, LocalDate returnDate, int assetNo, int employeeId) {
		super();
		this.allocationId = allocationId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
		this.assetNo = assetNo;
		this.employeeId = employeeId;
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
		return "AssetAllocation [allocationId=" + allocationId + ", allocationDate=" + allocationDate + ", returnDate="
				+ returnDate + ", assetNo=" + assetNo + ", employeeId=" + employeeId + "]";
	}

	
	
	
    
}
