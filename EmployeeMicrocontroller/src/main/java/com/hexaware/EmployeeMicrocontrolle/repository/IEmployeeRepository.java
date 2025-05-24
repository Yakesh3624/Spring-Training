package com.hexaware.EmployeeMicrocontrolle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.EmployeeMicrocontroller.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
