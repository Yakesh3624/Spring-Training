package com.hexaware.AdminMicrocontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.AdminMicrocontroller.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
