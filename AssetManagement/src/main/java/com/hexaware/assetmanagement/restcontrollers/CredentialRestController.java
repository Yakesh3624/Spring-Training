package com.hexaware.assetmanagement.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.Credential;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/credentaial")
public class CredentialRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add")
	Credential addCredential(@RequestBody Credential credential)
	{
		return service.addCredential(credential);
	}
	
	@GetMapping("/get/{userId}")
	Credential getCredentialByUserId(@PathVariable int userId)
	{
		return service.getCredentialByUserId(userId);
	}
	
	@GetMapping("/authenticate/{userName}/{password}")
	Credential authenticate(@PathVariable String userName,@PathVariable String password)
	{
		return service.authenticate(userName, password);
	}
	
	@PutMapping("/update/{userName}/{password}")
	String updatePassword(@PathVariable int userName,@PathVariable String password)
	{
		return service.updatePassword(userName, password);
	}
	
	@DeleteMapping("/delete/{userId}")
	String deleteCredential(@PathVariable int userId)
	{
		return service.deleteCredential(userId);
	}

}
