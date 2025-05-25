package com.hexaware.AdminMicrocontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.AdminMicrocontroller.entities.Credential;

import jakarta.transaction.Transactional;

@Transactional
public interface ICredentialRepository extends JpaRepository<Credential, Integer> {
	
	public Credential findByUserName(String userName);
	
	public Credential findByAdminId(int adminId);
	
	@Modifying
	@Query("update Credential c set c.password = ?2 where c.userName= ?1")
	int updatePassword(String userName,String password);
	
	@Query("select c from Credential c where c.userName=?1 and c.password=?2")
	Credential authenticate(String userName, String password);

}
