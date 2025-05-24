package com.hexaware.AdminMicrocontroller.restcontroller;

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

import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.service.IAdminService;

@RestController
@RequestMapping("/api/user")
public class AdminRestController {
	
	@Autowired
	IAdminService service;
	
	@PostMapping("/add")
	Admin addAdmin(@RequestBody Admin admin)
	{
		return service.addAdmin(admin);
	}
	
	@PutMapping("/update")
	Admin updateAdmin(@RequestBody Admin admin)
	{
		return service.updateAdmin(admin);
	}
	
	@DeleteMapping("/delete/{adminId}")
	String deleteAdmin(@PathVariable int adminId)
	{
		return service.deleteAdmin(adminId);
	}
	
	@GetMapping("/getbyid/{adminId}")
	Admin getAdminById(@PathVariable int adminId)
	{
		return service.getAdminById(adminId);
	}
	
	@GetMapping("getall")
	List<Admin> getAllAdmins()
	{
		return service.getAllAdmins();
	}
	
	

}
