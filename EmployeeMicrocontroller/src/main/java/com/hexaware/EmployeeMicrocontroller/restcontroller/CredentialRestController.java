package com.hexaware.EmployeeMicrocontroller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.EmployeeMicrocontroller.entities.Credential;
import com.hexaware.EmployeeMicrocontroller.service.IEmployeeService;

@RestController
@RequestMapping("/api/credentaial")
public class CredentialRestController {
	
	@Autowired
	IEmployeeService service;
	
	@PostMapping("/add")
	Credential addCredential(@RequestBody Credential credential)
	{
		return service.addCredential(credential);
	}
	
	@GetMapping("/get/{employeeId}")
	Credential getCredentialByEmployeeId(@PathVariable int employeeId)
	{
		return service.getCredentialByEmployeeId(employeeId);
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
	
	@DeleteMapping("/delete/{userId}")
	String deleteCredential(@PathVariable int employeeId)
	{
		return service.deleteCredential(employeeId);
	}

}
