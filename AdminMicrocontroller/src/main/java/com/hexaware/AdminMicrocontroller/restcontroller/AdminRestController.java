package com.hexaware.AdminMicrocontroller.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.AdminMicrocontroller.dto.AdminDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetAllocationDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.AuditRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.ServiceRequestDTO;
import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.exception.UserNotFoundException;
import com.hexaware.AdminMicrocontroller.service.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService service;
	
	@PostMapping("/add")
	AdminDTO addAdmin(@RequestBody Admin admin)
	{
		return service.addAdmin(admin);
	}
	
	@PutMapping("/update")
	AdminDTO updateAdmin(@RequestBody Admin admin) throws UserNotFoundException
	{
		return service.updateAdmin(admin);
	}
	
	@DeleteMapping("/delete/{adminId}")
	String deleteAdmin(@PathVariable int adminId)
	{
		return service.deleteAdmin(adminId);
	}
	
	@GetMapping("/getbyid/{adminId}")
	AdminDTO getAdminById(@PathVariable int adminId)
	{
		return service.getAdminById(adminId);
	}
	
	@GetMapping("/getall")
	List<AdminDTO> getAllAdmins()
	{
		return service.getAllAdmins();
	}
	
	
	
	
	
	
	
	@PostMapping("/asset/add")
	AssetDTO addAsset(AssetDTO asset)
	{
		return service.addAsset(asset);
	}
	
	@GetMapping("/asset/get-asset-by-no/{assetNo}")
	AssetDTO getAssetByNo(int assetNo)
	{
		return service.getAssetByNo(assetNo);
	}
	
	@GetMapping("/asset/getall")
	List<AssetDTO> getAllAssets()
	{
		return service.getAllAssets();
	}
	
	@GetMapping("/asset/get-asset-by-category/{category}")
	List<AssetDTO> getAssetsByCategory(String category)
	{
		return service.getAssetsByCategory(category);
	}
	
	@PutMapping("/asset/update")
	AssetDTO updateAsset(AssetDTO asset)
	{
		return service.updateAsset(asset);
	}
	
	@DeleteMapping("/asset/delete/{assetNo}")
	String deleteAsset(int assetNo)
	{
		return service.deleteAsset(assetNo);
	}
	
	@PostMapping("/asset-allocation/allocate-asset/{userId}/{assetNo}/{returnDate}")
	AssetAllocationDTO allocateAssetToUser(int userId, int assetNo, LocalDate returnDate)
	{
		return service.allocateAssetToUser(userId, assetNo, returnDate);
	}
	
	@GetMapping("/asset-allocation/get-allocation-by-id/{allocationId}")
	AssetAllocationDTO getAllocationById(int allocationId)
	{
		return service.getAllocationById(allocationId);
	}
	
	@GetMapping("/asset-allocation/getall")
	List<AssetAllocationDTO> getAllAllocations()
	{
		return service.getAllAllocations();
	}
	
	@GetMapping("/asset-allocation/get-allocation-by-employeeid/{userId}")
	List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId)
	{
		return service.getAllocationsByEmployeeId(employeeId);
	}
	
	@PutMapping("/asset-allocation/return/{allocationId}")
	String returnAsset(int allocationId)
	{
		return service.returnAsset(allocationId);
	}
	
	@PostMapping("/service-request/add")
	ServiceRequestDTO addServiceRequest(ServiceRequestDTO request)
	{
		return service.addServiceRequest(request);
	}
	
	@PutMapping("/service-request/update/{requestId}/{status}")
	ServiceRequestDTO updateServiceRequestStatus(int requestId, String status)
	{
		return service.updateServiceRequestStatus(requestId, status);
	}
	
	@GetMapping("/service-request/getall")
	List<ServiceRequestDTO> getAllRequests()
	{
		return service.getAllRequests();
	}
	
	@GetMapping("/service-request/get-by-employeeid/{employeeId}")
	List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId)
	{
		return service.getAllRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/service-request/get-by-requestid/{requestId}")
	List<ServiceRequestDTO> getAllRequestsByRequestId(@PathVariable int requestId)
	{
		return service.getAllRequestsByEmployeeId(requestId);
	}
	
	@GetMapping("/service-request/get-by-status/{status}")
	List<ServiceRequestDTO> getAllRequestsByStatus(String status)
	{
		return service.getAllRequestsByStatus(status);
	}
	
	@GetMapping("/service-request/get-by-issuetype/{issueType}")
	List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType)
	{
		return service.getAllRequestsByIssueType(issueType);
	}
	
	@PostMapping("/audit-request/add/{employeeId}/{assetNo}")
	AuditRequestDTO addAuditRequest(int employeeId, int assetNo)
	{
		return service.addAuditRequest(employeeId, assetNo);
	}
	
	@GetMapping("/audit-request/get-by-employeeid/{employeeId}")
	List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId)
	{
		return service.getAuditRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/audit-request/get-by-requestid/{requestId}")
	List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId)
	{
		return service.getAuditRequestsByRequestId(requestId);
	}
	
	@GetMapping("/audit-request/get-by-status/{status}")
	List<AuditRequestDTO> getAuditRequestsByStatus(String status)
	{
		return service.getAuditRequestsByStatus(status);
	}
	
	@GetMapping("/audit-request/getall")
	List<AuditRequestDTO> getAllAuditRequests()
	{
		return service.getAllAuditRequests();
	}
	
	@PutMapping("/audit-request/update-status/{auditId}/{status}")
	AuditRequestDTO updateAuditRequestStatus(int auditId, String status)
	{
		return service.updateAuditRequestStatus(auditId, status);
	}
	
	@PostMapping("/asset-request/add/{employeeIdId}/{assetNo}")
	AssetRequestDTO addAssetRequest(int employeeId, int assetNo)
	{
		return service.addAssetRequest(employeeId, assetNo);
	}
	
	@GetMapping("/asset-request/get-by-status/{status}")
	List<AssetRequestDTO> getAssetRequestsByStatus(String status)
	{
		return service.getAssetRequestsByStatus(status);
	}
	
	@GetMapping("/asset-request/getall")
	List<AssetRequestDTO> getAllAssetRequests()
	{
		return service.getAllAssetRequests();
	}
	
	@PutMapping("/asset-request/update-status/{assetNo}/{status}")
	AssetRequestDTO updateAssetRequestStatus(int auditNo, String status)
	{
		return service.updateAssetRequestStatus(auditNo, status);
	}
	
	@GetMapping("/asset-request/get-by-employeeid/{employeeId}")
	List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId)
	{
		return service.getAssetRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/asset-request/get-by-requestid/{requestId}")
	List<AssetRequestDTO> getAssetRequestsByRequestId(@PathVariable int requestId)
	{
		return service.getAssetRequestsByRequestId(requestId);
	}

	
	@PutMapping("/asset-allocation/grantasset/{userId}/{assetNo}/{returnDate}")
	AssetAllocationDTO grantAsset(int userId, int assetNo, LocalDate returnDate)
	{
		return service.grantAsset(userId, assetNo, returnDate);
	}
	

}
