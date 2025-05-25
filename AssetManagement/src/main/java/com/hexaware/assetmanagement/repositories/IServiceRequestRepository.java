package com.hexaware.assetmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.assetmanagement.entities.ServiceRequest;

import jakarta.transaction.Transactional;

@Transactional
public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

	@Modifying
	@Query(value="update service_request set status=?2 where request_id= ?1",nativeQuery = true)
	int updateServiceRequestStatus(int requestId, String status);

	List<ServiceRequest> findAllByEmployee_EmployeeId(int employeeId);

	List<ServiceRequest> findAllByStatus(String status);

	List<ServiceRequest> findAllByIssueType(String issueType);

}
