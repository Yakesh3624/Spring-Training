package com.hexaware.assetmanagement.restcontrollers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/assetallocation")
public class AssetAllocationRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/allocateasset/{userId}/{assetNo}/{returnDate}")
	AssetAllocation allocateAssetToUser(@PathVariable int userId,@PathVariable int assetNo,@PathVariable LocalDate returnDate)
	{
		return service.allocateAssetToUser(userId, assetNo, returnDate);
	}
	
	@GetMapping("/getallocationbyid/{allocationId}")
	AssetAllocation getAllocationById(int allocationId)
	{
		return service.getAllocationById(allocationId);
	}
	
	@GetMapping("/getallallocations")
	List<AssetAllocation> getAllAllocations()
	{
		return service.getAllAllocations();
	}
	
	@GetMapping("/getallocationbyemployeeid/{userId}")
	List<AssetAllocation> getAllocationsByEmployeeId(int employeeId)
	{
		return service.getAllocationsByUserId(employeeId);
	}
	
	@PutMapping("/return/{allocationId}")
	String returnAsset(int allocationId)
	{
		return service.returnAsset(allocationId);
	}

}
