package com.hexaware.EmployeeMicrocontroller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.EmployeeMicrocontrolle.repository.ICredentialRepository;
import com.hexaware.EmployeeMicrocontrolle.repository.IEmployeeRepository;
import com.hexaware.EmployeeMicrocontroller.entities.Credential;
import com.hexaware.EmployeeMicrocontroller.entities.Employee;

@Service
public class IEmployeeServiceImp implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepo;
	
	@Autowired
	ICredentialRepository credentialRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		
		return employeeRepo.findById(employeeId).orElse(null);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public String deleteEmployee(int employeeId) {
		employeeRepo.deleteById(employeeId);
		return employeeId+" deleted successfully";
	}

	@Override
	public Credential addCredential(Credential credential) {
		
		return credentialRepo.save(credential);
	}

	@Override
	public Credential getCredentialByEmployeeId(int employeeId) {
	
		return credentialRepo.findByEmployeeId(employeeId);
	}
	
	@Override
	public Credential getCredentialByUserName(String userName) {
		
		return credentialRepo.findByUserName(userName);
	}

	@Override
	public Credential authenticate(String userName, String password) {
		
		return credentialRepo.authenticate(userName,password);
	}

	@Override
	public int updatePassword(String userName, String password) {
		
		return credentialRepo.updatePassword(userName, password);
	}

	@Override
	public String deleteCredential(int employeeId) {
		credentialRepo.deleteById(employeeId);
		return employeeId+" credential deleted successfully";
	}

	
}
