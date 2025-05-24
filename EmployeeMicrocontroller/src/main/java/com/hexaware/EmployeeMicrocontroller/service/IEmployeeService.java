package com.hexaware.EmployeeMicrocontroller.service;

import java.util.List;

import com.hexaware.EmployeeMicrocontroller.entities.Credential;
import com.hexaware.EmployeeMicrocontroller.entities.Employee;


public interface IEmployeeService {
	
	Employee addEmployee(Employee user);
	Employee getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
	Employee updateEmployee(Employee employee);
	String deleteEmployee(int employeeId);
	
	Credential addCredential(Credential credential);
	Credential getCredentialByEmployeeId(int employeeId);
	Credential getCredentialByUserName(String userName);
	Credential authenticate(String userName, String password);
	int updatePassword(String userName, String password);
	String deleteCredential(int employeeId);
	
}
