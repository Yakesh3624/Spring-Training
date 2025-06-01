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

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.exceptions.DataAlreadyExistException;
import com.hexaware.assetmanagement.exceptions.DataNotFoundException;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/asset-request")
public class AssetRequestRestController {

	@Autowired
	IAssetManagementService service;

	@PostMapping("/add")
	public AssetRequestDTO addAssetRequest(@RequestBody AssetRequestDTO assetRequestDto)
			throws DataAlreadyExistException {
		return service.addAssetRequest(assetRequestDto);
	}

	@GetMapping("/getall")
	public List<AssetRequestDTO> getAllAssetRequests() throws DataNotFoundException {
		return service.getAllAssetRequests();
	}

	@GetMapping("/get/userId/{usersId}")
	public List<AssetRequestDTO> getAssetRequestsByUsersId(@PathVariable Long usersId) throws DataNotFoundException {
		return service.getAssetRequestsByUsersId(usersId);
	}

	@GetMapping("/get/status/{status}")
	public List<AssetRequestDTO> getAssetRequestsByStatus(@PathVariable String status) throws DataNotFoundException {
		return service.getAssetRequestsByStatus(status);
	}

	@GetMapping("/get/requestId/{requestId}")
	public AssetRequestDTO getAssetRequestsByRequestId(@PathVariable Long requestId) throws DataNotFoundException {
		return service.getAssetRequestsByRequestId(requestId);
	}

	@PutMapping("/update/status/{requestId}/{status}")
	public AssetRequestDTO updateassetRequestStatus(@PathVariable Long requestId, @PathVariable String status)
			throws DataNotFoundException {
		return service.updateAssetRequestStatus(requestId, status);
	}

}
