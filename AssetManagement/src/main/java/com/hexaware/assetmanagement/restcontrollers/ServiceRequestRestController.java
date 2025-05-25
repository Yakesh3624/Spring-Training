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

import com.hexaware.assetmanagement.dto.ServiceRequestDTO;
import com.hexaware.assetmanagement.entities.ServiceRequest;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/service-request")
public class ServiceRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add")
	ServiceRequestDTO addServiceRequest(@RequestBody ServiceRequest request)
	{
		return service.addServiceRequest(request);
	}
	
	@PutMapping("/update/{requestId}/{status}")
	int updateServiceRequestStatus(@PathVariable int requestId,@PathVariable String status)
	{
		return service.updateServiceRequestStatus(requestId, status);
	}
	
	@GetMapping("/getall")
	List<ServiceRequestDTO> getAllRequests()
	{
		return service.getAllRequests();
	}
	
	@GetMapping("/get-by-requestid/{requestId}")
	List<ServiceRequestDTO> getAllRequestsByRequestId(@PathVariable int requestId)
	{
		return service.getAllRequestsByEmployeeId(requestId);
	}
	
	@GetMapping("/get-by-employeeid/{employeeId}")
	List<ServiceRequestDTO> getAllRequestsByEmployeeId(@PathVariable int employeeId)
	{
		return service.getAllRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/get-by-status/{status}")
	List<ServiceRequestDTO> getAllRequestsByStatus(@PathVariable String status)
	{
		return service.getAllRequestsByStatus(status);
	}
	
	@GetMapping("/get-by-issuetype/{issueType}")
	List<ServiceRequestDTO> getAllRequestsByIssueType(@PathVariable String issueType)
	{
		return service.getAllRequestsByIssueType(issueType);
	}

}
