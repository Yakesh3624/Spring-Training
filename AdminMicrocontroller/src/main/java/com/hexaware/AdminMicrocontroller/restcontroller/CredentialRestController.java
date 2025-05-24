package com.hexaware.AdminMicrocontroller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.AdminMicrocontroller.entities.Credential;
import com.hexaware.AdminMicrocontroller.service.IAdminService;

@RestController
@RequestMapping("/api/credentaial")
public class CredentialRestController {
	
	@Autowired
	IAdminService service;
	
	@PostMapping("/add")
	Credential addCredential(@RequestBody Credential credential)
	{
		return service.addCredential(credential);
	}
	
	@GetMapping("/get/{adminId}")
	Credential getCredentialByAdminId(@PathVariable int adminId)
	{
		return service.getCredentialByAdminId(adminId);
	}
	
	@GetMapping("/authenticate/{userName}/{password}")
	Credential authenticate(@PathVariable String userName,@PathVariable String password)
	{
		return service.authenticate(userName, password);
	}
	
	@PutMapping("/update/{userName}/{password}")
	int updatePassword(@PathVariable String userName,@PathVariable String password)
	{
		return service.updatePassword(userName, password);
	}
	
	@DeleteMapping("/delete/{adminId}")
	String deleteCredential(@PathVariable int adminId)
	{
		return service.deleteCredential(adminId);
	}

}
