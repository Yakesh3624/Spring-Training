package com.hexaware.assetmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/auditrequest")
public class AuditRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add/{employeeId}/{assetNo}")
	AuditRequest addAuditRequest(@PathVariable int employeeId,@PathVariable int assetNo)
	{
		return service.addAuditRequest(employeeId, assetNo);
	}
	
	@GetMapping("/getbyempolyeeid/{employeeId}")
	List<AuditRequest> getAuditRequestsByEmployeeId(@PathVariable int userId)
	{
		return service.getAuditRequestsByEmployeeId(userId);
	}
	
	@GetMapping("/getbyrequestid/{requestId}")
	List<AuditRequest> getAuditRequestsByRequestId(@PathVariable int requestId)
	{
		return service.getAuditRequestsByRequestId(requestId);
	}
	
	@GetMapping("/getbystatus/{status}")
	List<AuditRequest> getAuditRequestsByStatus(@PathVariable String status)
	{
		return service.getAuditRequestsByStatus(status);
	}
	
	@GetMapping("/getall")
	List<AuditRequest> getAllAuditRequests()
	{
		return service.getAllAuditRequests();
	}
	
	@PutMapping("/updatestatus/{auditNo}/{status}")
	AuditRequest updateAuditRequestStatus(int auditNo, String status)
	{
		return service.updateAuditRequestStatus(auditNo, status);
	}

}
