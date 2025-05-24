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
	
	
	AssetDTO addAsset(AssetDTO asset)
	{
		return service.addAsset(asset);
	}
	AssetDTO getAssetByNo(int assetNo)
	{
		return service.getAssetByNo(assetNo);
	}
	List<AssetDTO> getAllAssets()
	{
		return service.getAllAssets();
	}
	List<AssetDTO> getAssetsByCategory(String category)
	{
		return service.getAssetsByCategory(category);
	}
	AssetDTO updateAsset(AssetDTO asset)
	{
		return service.updateAsset(asset);
	}
	String deleteAsset(int assetNo)
	{
		return service.deleteAsset(assetNo);
	}
	
	AssetAllocationDTO allocateAssetToUser(int userId, int assetNo, LocalDate returnDate)
	{
		return service.allocateAssetToUser(userId, assetNo, returnDate);
	}
	AssetAllocationDTO getAllocationById(int allocationId)
	{
		return service.getAllocationById(allocationId);
	}
	List<AssetAllocationDTO> getAllAllocations()
	{
		return service.getAllAllocations();
	}
	List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId)
	{
		return service.getAllocationsByEmployeeId(employeeId);
	}
	String returnAsset(int allocationId)
	{
		return service.returnAsset(allocationId);
	}
	
	ServiceRequestDTO addServiceRequest(ServiceRequestDTO request)
	{
		return service.addServiceRequest(request);
	}
	ServiceRequestDTO updateServiceRequestStatus(int requestId, String status)
	{
		return service.updateServiceRequestStatus(requestId, status);
	}
	List<ServiceRequestDTO> getAllRequests()
	{
		return service.getAllRequests();
	}
	List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId)
	{
		return service.getAllRequestsByEmployeeId(employeeId);
	}
	List<ServiceRequestDTO> getAllRequestsByStatus(String status)
	{
		return service.getAllRequestsByStatus(status);
	}
	List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType)
	{
		return service.getAllRequestsByIssueType(issueType);
	}
	
	AuditRequestDTO addAuditRequest(int employeeId, int assetNo)
	{
		return service.addAuditRequest(employeeId, assetNo);
	}
	List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId)
	{
		return service.getAuditRequestsByEmployeeId(employeeId);
	}
	List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId)
	{
		return service.getAuditRequestsByRequestId(requestId);
	}
	List<AuditRequestDTO> getAuditRequestsByStatus(String status)
	{
		return service.getAuditRequestsByStatus(status);
	}
	List<AuditRequestDTO> getAllAuditRequests()
	{
		return service.getAllAuditRequests();
	}
	AuditRequestDTO updateAuditRequestStatus(int auditNo, String status)
	{
		return service.updateAuditRequestStatus(auditNo, status);
	}
	
	AssetRequestDTO addAssetRequest(int employeeId, int assetNo)
	{
		return service.addAssetRequest(employeeId, assetNo);
	}
	List<AssetRequestDTO> getAssetRequestsByStatus(String status)
	{
		return service.getAssetRequestsByStatus(status);
	}
	List<AssetRequestDTO> getAllAssetRequests()
	{
		return service.getAllAssetRequests();
	}
	AssetRequestDTO updateAssetRequestStatus(int auditNo, String status)
	{
		return service.updateAssetRequestStatus(auditNo, status);
	}
	List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId)
	{
		return service.getAssetRequestsByEmployeeId(employeeId);
	}
	AssetAllocationDTO grantAsset(int userId, int assetNo, LocalDate returnDate)
	{
		return service.grantAsset(userId, assetNo, returnDate);
	}
	

}
