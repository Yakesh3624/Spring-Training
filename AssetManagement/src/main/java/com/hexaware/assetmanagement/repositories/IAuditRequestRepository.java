package com.hexaware.assetmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.assetmanagement.entities.AuditRequest;

import jakarta.transaction.Transactional;

@Transactional
public interface IAuditRequestRepository extends JpaRepository<AuditRequest, Integer> {

	@Query(value="insert into audit_request(employee_id,asset_no) values(?1,?2)",nativeQuery = true)
	AuditRequest addAuditRequest(int employeeId, int assetNo);

	List<AuditRequest> findAllByEmployee_EmployeeId(int employeeId);

	List<AuditRequest> findAllByStatus(String status);

	@Modifying
	@Query(value="update audit_request set status=?2 where requestId=?1",nativeQuery = true)
	int updateAuditRequestStatus(int requestId, String status);

	List<AuditRequest> findAllByRequestId(int requestId);

}
