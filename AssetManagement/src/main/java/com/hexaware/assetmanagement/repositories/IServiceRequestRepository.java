package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.ServiceRequest;

public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

}
