package com.hexaware.assetmanagement.restcontrollers;

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

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("api/asset")
public class AssetRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add")
	AssetDTO addAsset(@RequestBody Asset asset)
	{
		return service.addAsset(asset);
	}
	
	@GetMapping("/get-asset-by-no/{assetNo}")
	AssetDTO getAssetByNo(@PathVariable int assetNo)
	{
		return service.getAssetByNo(assetNo);
	}
	
	@GetMapping("/getall")
	List<AssetDTO> getAllAssets()
	{
		return service.getAllAssets();
	}
	
	@GetMapping("/get-asset-by-category/{category}")
	List<AssetDTO> getAssetsByCategory(@PathVariable String category)
	{
		return service.getAssetsByCategory(category);
	}
	
	@PutMapping("/update")
	AssetDTO updateAsset(@RequestBody Asset asset)
	{
		return service.updateAsset(asset);
	}
	
	@DeleteMapping("/delete/{assetNo}")
	String deleteAsset(@PathVariable int assetNo)
	{
		return service.deleteAsset(assetNo);
	}

}
