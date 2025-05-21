package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.AuditRequest;

public interface IAuditRequestRepository extends JpaRepository<AuditRequest, Integer> {

}
