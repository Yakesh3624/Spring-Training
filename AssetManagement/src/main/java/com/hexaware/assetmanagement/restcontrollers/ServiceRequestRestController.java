package com.hexaware.assetmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/servicerequest")
public class ServiceRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add")
	ServiceRequest addServiceRequest(@RequestBody ServiceRequest request)
	{
		return service.addServiceRequest(request);
	}
	
	@PutMapping("/update/{requestId}/{status}")
	ServiceRequest updateServiceRequestStatus(@PathVariable int requestId,@PathVariable String status)
	{
		return service.updateServiceRequestStatus(requestId, status);
	}
	
	@GetMapping("/getall")
	List<ServiceRequest> getAllRequests()
	{
		return service.getAllRequests();
	}
	
	@GetMapping("/getbyid/{userId}")
	List<ServiceRequest> getAllRequestsByUserId(@PathVariable int userId)
	{
		return service.getAllRequestsByUserId(userId);
	}
	
	@GetMapping("/getbystatus/{status}")
	List<ServiceRequest> getAllRequestsByStatus(@PathVariable String status)
	{
		return service.getAllRequestsByStatus(status);
	}
	
	@GetMapping("/getbyissuetype/{issueType}")
	List<ServiceRequest> getAllRequestsByIssueType(@PathVariable String issueType)
	{
		return service.getAllRequestsByIssueType(issueType);
	}

}
