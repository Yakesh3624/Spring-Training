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

import com.hexaware.assetmanagement.dto.AssetAllocationDTO;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/asset-allocation")
public class AssetAllocationRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/allocate-asset/{EmployeeId}/{assetNo}/{returnDate}")
	AssetAllocationDTO allocateAssetToEmployee(@PathVariable int employeeId,@PathVariable int assetNo,@PathVariable LocalDate returnDate)
	{
		return service.allocateAssetToEmployee(employeeId, assetNo, returnDate);
	}
	
	@GetMapping("/get-allocation-by-id/{allocationId}")
	AssetAllocationDTO getAllocationById(int allocationId)
	{
		return service.getAllocationById(allocationId);
	}
	
	@GetMapping("/getall")
	List<AssetAllocationDTO> getAllAllocations()
	{
		return service.getAllAllocations();
	}
	
	@GetMapping("/get-allocation-by-employeeid/{employeeId}")
	List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId)
	{
		return service.getAllocationsByEmployeeId(employeeId);
	}
	
	@PutMapping("/return/{allocationId}")
	int returnAsset(int allocationId)
	{
		return service.returnAsset(allocationId);
	}

}
