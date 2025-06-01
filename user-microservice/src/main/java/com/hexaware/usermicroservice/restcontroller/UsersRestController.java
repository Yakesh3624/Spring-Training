package com.hexaware.usermicroservice.restcontroller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hexaware.usermicroservice.dto.AssetAllocationDTO;
import com.hexaware.usermicroservice.dto.AssetDTO;
import com.hexaware.usermicroservice.dto.AssetRequestDTO;
import com.hexaware.usermicroservice.dto.AuditRequestDTO;
import com.hexaware.usermicroservice.dto.ServiceRequestDTO;
import com.hexaware.usermicroservice.dto.UsersDTO;
import com.hexaware.usermicroservice.entity.Users;
import com.hexaware.usermicroservice.exception.DataAlreadyExistException;
import com.hexaware.usermicroservice.exception.DataNotFoundException;
import com.hexaware.usermicroservice.service.IUsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	IUsersService service;

	// Users

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public UsersDTO updateUsers(@Valid @RequestBody Users users) throws DataNotFoundException {
		return service.updateUsers(users);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/getall")
	public List<UsersDTO> getAllUsers() throws DataNotFoundException {
		return service.getAllUsers();
	}

	@GetMapping("/get/{usersId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public UsersDTO getUsersByUsersId(@PathVariable Long usersId) throws DataNotFoundException {
		return service.getUsersByUsersId(usersId);
	}

	@DeleteMapping("/delete/{usersId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUsersById(@PathVariable Long usersId) throws DataNotFoundException {
		return service.deleteUsersById(usersId);
	}

	// Asset

	@PostMapping("/asset/add")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AssetDTO addAsset(@RequestBody AssetDTO asset) throws DataAlreadyExistException {
		return restTemplate.postForObject("http://localhost:8081/api/asset/add", asset, AssetDTO.class);
	}

	@PutMapping("/asset/update")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AssetDTO updateAsset(@RequestBody AssetDTO asset) throws DataNotFoundException {
		restTemplate.put("http://localhost:8081/api/asset/update", asset, AssetDTO.class);
		return restTemplate.getForObject("http://localhost:8081/api/asset/get-by-assetno/" + asset.getAssetNo(),
				AssetDTO.class);
	}

	@PutMapping("/asset/update/availability/{assetNo}/{availability}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AssetDTO updateAssetAvailability(@PathVariable Long assetNo, @PathVariable String availability)
			throws DataNotFoundException {
		restTemplate.put("http://localhost:8081/api/asset/update/availability/" + assetNo + "/" + availability,
				availability);
		return restTemplate.getForObject("http://localhost:8081/api/asset/get-by-assetno/" + assetNo, AssetDTO.class);
	}

	@GetMapping("/asset/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public List<AssetDTO> getAllAssets() throws DataNotFoundException {
		AssetDTO[] assetArray = restTemplate.getForObject("http://localhost:8081/api/asset/getall", AssetDTO[].class);
		List<AssetDTO> assetList = Arrays.asList(assetArray);
		return assetList;

	}

	@GetMapping("/asset/get/assetno/{assetNo}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public AssetDTO getAssetByAssetNo(@PathVariable Long assetNo) throws DataNotFoundException {
		return restTemplate.getForObject("http://localhost:8081/api/asset/get-by-assetno/" + assetNo, AssetDTO.class);
	}

	@GetMapping("/asset/get/category/category/{category}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public List<AssetDTO> getAssetsByCategory(@PathVariable String category) throws DataNotFoundException {
		AssetDTO[] assetArray = restTemplate
				.getForObject("http://localhost:8081/api/asset/get-by-category/category/" + category, AssetDTO[].class);
		List<AssetDTO> assetList = Arrays.asList(assetArray);
		return assetList;
	}

	@GetMapping("/asset/get/availability/{availability}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public List<AssetDTO> getAssetsByAvailability(@PathVariable String availability) throws DataNotFoundException {
		AssetDTO[] assetArray = restTemplate
				.getForObject("http://localhost:8081/api/asset/get-by-availability/" + availability, AssetDTO[].class);
		List<AssetDTO> assetList = Arrays.asList(assetArray);
		return assetList;
	}

	@DeleteMapping("/asset/delete/{assetNo}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public String deleteAssetByAssetNo(@PathVariable Long assetNo) throws DataNotFoundException {
		restTemplate.delete("http://localhost:8081/api/asset/delete/" + assetNo);
		return "Asset with assetNo " + assetNo + " deleted successfully";
	}

	// Asset Allocation

	@PostMapping("/asset-allocation/allocate/{usersId}/{assetNo}/{returnDate}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AssetAllocationDTO allocateAssetToUser(@PathVariable Long usersId, @PathVariable Long assetNo,
			@PathVariable LocalDate returnDate) throws DataNotFoundException {
		return restTemplate.postForObject(
				"http://localhost:8081/api/asset-allocation/allocate/" + usersId + "/" + assetNo + "/" + returnDate,
				null, AssetAllocationDTO.class);
	}

	@GetMapping("/asset-allocation/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<AssetAllocationDTO> getAllAllocations() throws DataNotFoundException {
		AssetAllocationDTO[] assetAllocationArray = restTemplate
				.getForObject("http://localhost:8081/api/asset-allocation/getall", AssetAllocationDTO[].class);
		List<AssetAllocationDTO> assetList = Arrays.asList(assetAllocationArray);
		return assetList;

	}

	@GetMapping("/asset-allocation/get/allocationId/{allocationId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public AssetAllocationDTO getAllocationByAllocationId(@PathVariable Long allocationId)
			throws DataNotFoundException {
		return restTemplate.getForObject("http://localhost:8081/api/asset-allocation/get/allocationId/" + allocationId,
				AssetAllocationDTO.class);
	}

	@GetMapping("/asset-allocation/get/asset-No/{assetNo}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AssetAllocationDTO getAllocationByAssetNo(@PathVariable Long assetNo) throws DataNotFoundException {
		return restTemplate.getForObject("http://localhost:8081/api/asset-allocation/get/asset-No/" + assetNo,
				AssetAllocationDTO.class);
	}

	@GetMapping("/asset-allocation/get/users-Id/{usersId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public List<AssetAllocationDTO> getAllocationsByUserId(@PathVariable Long usersId) throws DataNotFoundException {
		AssetAllocationDTO[] assetAllocationArray = restTemplate.getForObject(
				"http://localhost:8081/api/asset-allocation/get/users-Id/" + usersId, AssetAllocationDTO[].class);
		List<AssetAllocationDTO> assetList = Arrays.asList(assetAllocationArray);
		return assetList;

	}

	@DeleteMapping("/asset-allocation/return/{allocationId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public String returnAsset(@PathVariable Long allocationId) throws DataNotFoundException {
		restTemplate.delete("http://localhost:8081/api/asset-allocation/return/" + allocationId);
		return "Asset with allocation " + allocationId + " was deleted successfully";
	}

	// Audit Request Operation

	@PostMapping("/audit-request/add")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	AuditRequestDTO addAuditRequest(@RequestBody AuditRequestDTO auditRequestDto) throws DataAlreadyExistException {
		return restTemplate.postForObject("http://localhost:8081/api/audit-request/add", auditRequestDto,
				AuditRequestDTO.class);
	}

	@GetMapping("/audit-request/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<AuditRequestDTO> getAllAuditRequests() throws DataNotFoundException {
		AuditRequestDTO[] auditRequestArray = restTemplate
				.getForObject("http://localhost:8081/api/audit-request/getall", AuditRequestDTO[].class);
		List<AuditRequestDTO> auditRequestList = Arrays.asList(auditRequestArray);
		return auditRequestList;
	}

	@GetMapping("/audit-request/get/userId/{usersId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	List<AuditRequestDTO> getAuditRequestsByUsersId(@PathVariable Long usersId) throws DataNotFoundException {
		AuditRequestDTO[] auditRequestArray = restTemplate.getForObject(
				"http://localhost:8081/api/audit-request/get/usersId/" + usersId, AuditRequestDTO[].class);
		List<AuditRequestDTO> auditRequestList = Arrays.asList(auditRequestArray);
		return auditRequestList;
	}

	@GetMapping("/audit-request/get/status/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	List<AuditRequestDTO> getAuditRequestsByStatus(@PathVariable String status) throws DataNotFoundException {
		AuditRequestDTO[] auditRequestArray = restTemplate
				.getForObject("http://localhost:8081/api/audit-request/get/status/" + status, AuditRequestDTO[].class);
		List<AuditRequestDTO> auditRequestList = Arrays.asList(auditRequestArray);
		return auditRequestList;
	}

	@GetMapping("/audit-request/get/requestId/{requestId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	AuditRequestDTO getAuditRequestsByRequestId(@PathVariable Long requestId) throws DataNotFoundException {
		return restTemplate.getForObject("http://localhost:8081/api/audit-request/get/requestId/" + requestId,
				AuditRequestDTO.class);

	}

	@PutMapping("/audit-request/update/status/{requestId}/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	AuditRequestDTO updateAuditRequestStatus(@PathVariable Long requestId, @PathVariable String status)
			throws DataNotFoundException {
		restTemplate.put("http://localhost:8081/api/audit-request/update/status/" + requestId + "/" + status, null);

		return restTemplate.getForObject("http://localhost:8081/api/audit-request/get/requestId/" + requestId,
				AuditRequestDTO.class);
	}

	// Asset Request Operations
	@PostMapping("/asset-request/add")
	@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
	AssetRequestDTO addAssetRequest(@RequestBody AssetRequestDTO assetRequestDto) throws DataAlreadyExistException {
		return restTemplate.postForObject("http://localhost:8081/api/asset-request/add", assetRequestDto,
				AssetRequestDTO.class);

	}

	@GetMapping("/asset-request/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<AssetRequestDTO> getAllAssetRequests() throws DataNotFoundException {
		AssetRequestDTO[] assetRequestArray = restTemplate
				.getForObject("http://localhost:8081/api/asset-request/getall", AssetRequestDTO[].class);
		List<AssetRequestDTO> assetRequestList = Arrays.asList(assetRequestArray);
		return assetRequestList;
	}

	@GetMapping("/asset-request/get/userId/{usersId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	List<AssetRequestDTO> getAssetRequestsByUsersId(@PathVariable Long usersId) throws DataNotFoundException {
		AssetRequestDTO[] assetRequestArray = restTemplate.getForObject(
				"http://localhost:8081/api/asset-request/get/usersId/" + usersId, AssetRequestDTO[].class);
		List<AssetRequestDTO> assetRequestList = Arrays.asList(assetRequestArray);
		return assetRequestList;
	}

	@GetMapping("/asset-request/get/status/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<AssetRequestDTO> getAssetRequestsByStatus(@PathVariable String status) throws DataNotFoundException {
		AssetRequestDTO[] assetRequestArray = restTemplate
				.getForObject("http://localhost:8081/api/asset-request/get/status/" + status, AssetRequestDTO[].class);
		List<AssetRequestDTO> assetRequestList = Arrays.asList(assetRequestArray);
		return assetRequestList;
	}

	@GetMapping("/asset-request/get/requestId/{requestId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	AssetRequestDTO getAssetRequestsByRequestId(@PathVariable Long requestId) throws DataNotFoundException {
		return restTemplate.getForObject("http://localhost:8081/api/asset-request/get/requestId/" + requestId,
				AssetRequestDTO.class);
	}

	@PutMapping("/asset-request/update/status/{requestId}/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	AssetRequestDTO updateAssetRequestStatus(@PathVariable Long requestId, @PathVariable String status)
			throws DataNotFoundException {
		restTemplate.put("http://localhost:8081/api/asset-request/update/" + requestId + "/" + status, requestId);

		return restTemplate.getForObject("http://localhost:8081/api/asset-request/get/requestId/" + requestId,
				AssetRequestDTO.class);
	}

	// Service Request

	@PostMapping("/service-request/add")
	@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
	ServiceRequestDTO addServiceRequest(@RequestBody ServiceRequestDTO serviceRequestDto)
			throws DataNotFoundException, DataAlreadyExistException {
		return restTemplate.postForObject("http://localhost:8081/api/service-request/add", serviceRequestDto,
				ServiceRequestDTO.class);

	}

	@PutMapping("/service-request/update/status/{requestId}/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	ServiceRequestDTO updateServiceRequestStatus(@PathVariable Long requestId, @PathVariable String status)
			throws DataNotFoundException {
		restTemplate.put("http://localhost:8081/api/service-request/update/status/" + requestId + "/" + status, null);
		return restTemplate.getForObject("http://localhost:8081/api/service-request/get/requestId/" + requestId,
				ServiceRequestDTO.class);
	}

	@GetMapping("/service-request/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<ServiceRequestDTO> getAllServiceRequests() throws DataNotFoundException {
		ServiceRequestDTO[] serviceRequestArray = restTemplate
				.getForObject("http://localhost:8081/api/service-request/getall", ServiceRequestDTO[].class);
		List<ServiceRequestDTO> serviceRequestList = Arrays.asList(serviceRequestArray);
		return serviceRequestList;

	}

	@GetMapping("/service-request/get/usersId/{usersId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	List<ServiceRequestDTO> getAllServiceRequestsByUsersId(@PathVariable Long usersId) throws DataNotFoundException {
		ServiceRequestDTO[] serviceRequestArray = restTemplate.getForObject(
				"http://localhost:8081/api/service-request/get/usersId/" + usersId, ServiceRequestDTO[].class);
		List<ServiceRequestDTO> serviceRequestList = Arrays.asList(serviceRequestArray);
		return serviceRequestList;
	}

	@GetMapping("/service-request/get/requestId/{requestId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	ServiceRequestDTO getServiceRequestsByRequestId(@PathVariable Long requestId) throws DataNotFoundException {

		return restTemplate.getForObject("http://localhost:8081/api/service-request/get/requestId/" + requestId,
				ServiceRequestDTO.class);
	}

	@GetMapping("/service-request/get/status/{status}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<ServiceRequestDTO> getAllServiceRequestsByStatus(@PathVariable String status) throws DataNotFoundException {
		ServiceRequestDTO[] serviceRequestArray = restTemplate.getForObject(
				"http://localhost:8081/api/service-request/get/status/" + status, ServiceRequestDTO[].class);
		List<ServiceRequestDTO> serviceRequestList = Arrays.asList(serviceRequestArray);
		return serviceRequestList;
	}

	@GetMapping("/service-request/get/issue-type/{issueType}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	List<ServiceRequestDTO> getAllServiceRequestsByIssueType(@PathVariable String issueType)
			throws DataNotFoundException {
		ServiceRequestDTO[] serviceRequestArray = restTemplate.getForObject(
				"http://localhost:8081/api/service-request/get/issue-type/" + issueType, ServiceRequestDTO[].class);
		List<ServiceRequestDTO> serviceRequestList = Arrays.asList(serviceRequestArray);
		return serviceRequestList;
	}
}
