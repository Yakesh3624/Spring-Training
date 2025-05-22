package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.assetmanagement.entities.Credential;

public interface ICredentialRepository extends JpaRepository<Credential, Integer> {
	
	public Credential findByUserName(String userName);
	
	@Query("update Credential c set password = ?2where user_name= ?1")
	public int updatePassword(String userName,String password);

}
