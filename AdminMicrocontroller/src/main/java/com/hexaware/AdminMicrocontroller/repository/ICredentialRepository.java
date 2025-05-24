package com.hexaware.AdminMicrocontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.AdminMicrocontroller.entities.Credential;

public interface ICredentialRepository extends JpaRepository<Credential, Integer> {
	
	public Credential findByUserName(String userName);
	
	public Credential findByAdminId(int adminId);
	
	@Query("update Credential c set password = ?2where user_name= ?1")
	public int updatePassword(String userName,String password);
	
	@Query("select c from Credential c where userName=?1 , password=?2")
	public Credential authenticate(String userName, String password);

}
