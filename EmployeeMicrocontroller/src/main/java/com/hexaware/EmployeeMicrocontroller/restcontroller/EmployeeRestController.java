package com.hexaware.EmployeeMicrocontroller.restcontroller;

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

import com.hexaware.EmployeeMicrocontroller.entities.Employee;
import com.hexaware.EmployeeMicrocontroller.service.IEmployeeService;

@RestController
@RequestMapping("/api/user")
public class EmployeeRestController {
	
	@Autowired
	IEmployeeService service;
	
	@PostMapping("/add")
	Employee addUser(@RequestBody Employee employee)
	{
		return service.addEmployee(employee);
	}
	
	@GetMapping("/getbyid/{employeeId}")
	Employee getEmployeeById(@PathVariable int employeeId)
	{
		return service.getEmployeeById(employeeId);
	}
	
	@GetMapping("getall")
	List<Employee> getAllEmployees()
	{
		return service.getAllEmployees();
	}
	
	@PutMapping("/update")
	Employee updateUser(@RequestBody Employee employee)
	{
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	String deleteEmployee(@PathVariable int employeeId)
	{
		return service.deleteEmployee(employeeId);
	}

}
