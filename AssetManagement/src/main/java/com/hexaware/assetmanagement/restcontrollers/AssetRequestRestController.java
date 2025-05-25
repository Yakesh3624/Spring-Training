package com.hexaware.assetmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/asset-request")
public class AssetRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add/{employeeIdId}/{assetNo}")
	int addAssetRequest(@PathVariable int employeeId,@PathVariable int assetNo)
	{
		return service.addAssetRequest(employeeId, assetNo);
	}
	
	@GetMapping("/get-by-employeeid/{employeeId}")
	List<AssetRequestDTO> getAssetRequestsByEmployeeId(@PathVariable int employeeId)
	{
		return service.getAssetRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/get-by-requestid/{requestId}")
	List<AssetRequestDTO> getAssetRequestsByRequesteId(@PathVariable int requestId)
	{
		return service.getAssetRequestsByRequestId(requestId);
	}
	
	@GetMapping("/get-by-status/{status}")
	List<AssetRequestDTO> getAssetRequestsByStatus(@PathVariable String status)
	{
		return service.getAssetRequestsByStatus(status);
	}
	
	@GetMapping("/getall")
	List<AssetRequestDTO> getAllAssetRequests()
	{
		return service.getAllAssetRequests();
	}
	
	@PutMapping("/update-status/{assetNo}/{status}")
	int updateAssetRequestStatus(int assetNo, String status)
	{
		return service.updateAssetRequestStatus(assetNo, status);
	}

}
