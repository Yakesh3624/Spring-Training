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

import com.hexaware.assetmanagement.entities.Users;
import com.hexaware.assetmanagement.services.IAssetManagementService;

@RestController
@RequestMapping("/api/user")
public class UsersRestController {
	
	@Autowired
	IAssetManagementService service;
	
	@PostMapping("/add")
	Users addUser(@RequestBody Users user)
	{
		return service.addUser(user);
	}
	
	@GetMapping("/getbyid/{userId}")
	Users getUserById(@PathVariable int userId)
	{
		return service.getUserById(userId);
	}
	
	@GetMapping("getall")
	List<Users> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@PutMapping("/update")
	Users updateUser(@RequestBody Users user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("/delete/{userId}")
	String deleteUser(@PathVariable int userId)
	{
		return service.deleteUser(userId);
	}

}
