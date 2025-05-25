package com.hexaware.assetmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AuditRequestDTO;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/audit-request")
public class AuditRequestRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add/{employeeId}/{assetNo}")
	AuditRequestDTO addAuditRequest(@PathVariable int employeeId,@PathVariable int assetNo)
	{
		return service.addAuditRequest(employeeId, assetNo);
	}
	
	@GetMapping("/get-by-empolyeeid/{employeeId}")
	List<AuditRequestDTO> getAuditRequestsByEmployeeId(@PathVariable int employeeId)
	{
		return service.getAuditRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/get-by-requestid/{requestId}")
	List<AuditRequestDTO> getAuditRequestsByRequestId(@PathVariable int requestId)
	{
		return service.getAuditRequestsByRequestId(requestId);
	}
	
	@GetMapping("/get-by-status/{status}")
	List<AuditRequestDTO> getAuditRequestsByStatus(@PathVariable String status)
	{
		return service.getAuditRequestsByStatus(status);
	}
	
	@GetMapping("/getall")
	List<AuditRequestDTO> getAllAuditRequests()
	{
		return service.getAllAuditRequests();
	}
	
	@PutMapping("/update-status/{auditId}/{status}")
	int updateAuditRequestStatus(int auditId, String status)
	{
		return service.updateAuditRequestStatus(auditId, status);
	}

}
