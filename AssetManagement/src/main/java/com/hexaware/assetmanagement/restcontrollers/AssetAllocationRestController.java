package com.hexaware.assetmanagement.restcontrollers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetAllocationDTO;
import com.hexaware.assetmanagement.exceptions.DataNotFoundException;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/asset-allocation")
public class AssetAllocationRestController {

	@Autowired
	IAssetManagementService service;

	@PostMapping("/allocate/{usersId}/{assetNo}/{returnDate}")
	AssetAllocationDTO allocateAssetToUser(@PathVariable Long usersId, @PathVariable Long assetNo,
			@PathVariable LocalDate returnDate) throws DataNotFoundException {
		return service.allocateAssetToUser(usersId, assetNo, returnDate);
	}

	@GetMapping("/getall")
	List<AssetAllocationDTO> getAllAllocations() throws DataNotFoundException {
		return service.getAllAllocations();
	}

	@GetMapping("/get/allocationId/{allocationId}")
	AssetAllocationDTO getAllocationByAllocationId(@PathVariable Long allocationId) throws DataNotFoundException {
		return service.getAllocationByAllocationId(allocationId);
	}

	@GetMapping("/get/asset-No/{assetNo}")
	AssetAllocationDTO getAllocationByAssetNo(@PathVariable Long assetNo) throws DataNotFoundException {
		return service.getAllocationByAssetNo(assetNo);
	}

	@GetMapping("/get/users-Id/{usersId}")
	List<AssetAllocationDTO> getAllocationsByUserId(@PathVariable Long usersId) throws DataNotFoundException {
		return service.getAllocationsByUserId(usersId);
	}

	@DeleteMapping("/return/{allocationId}")
	String returnAsset(@PathVariable Long allocationId) throws DataNotFoundException {
		return service.returnAsset(allocationId);
	}

}
