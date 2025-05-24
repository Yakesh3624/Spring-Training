package com.hexaware.assetmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/auditrequest")
public class AssetRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add/{userId}/{assetNo}")
	AssetRequest addAssetRequest(@PathVariable int userId,@PathVariable int assetNo)
	{
		return service.addAssetRequest(userId, assetNo);
	}
	
	@GetMapping("/getbyemployeeid/{employeeId}")
	List<AssetRequest> getAssetRequestsByEmployeeId(@PathVariable int employeeId)
	{
		return service.getAssetRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/getbystatus/{status}")
	List<AssetRequest> getAssetRequestsByStatus(@PathVariable String status)
	{
		return service.getAssetRequestsByStatus(status);
	}
	
	@GetMapping("/getall")
	List<AssetRequest> getAllAssetRequests()
	{
		return service.getAllAssetRequests();
	}
	
	@PutMapping("/updatestatus/{auditNo}/{status}")
	AssetRequest updateAssetRequestStatus(int auditNo, String status)
	{
		return service.updateAssetRequestStatus(auditNo, status);
	}

}
