package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.Credential;

public interface ICredentialRepository extends JpaRepository<Credential, Integer> {

}
