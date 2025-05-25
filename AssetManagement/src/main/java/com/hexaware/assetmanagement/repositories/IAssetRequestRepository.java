package com.hexaware.assetmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.assetmanagement.entities.AssetRequest;

import jakarta.transaction.Transactional;

@Transactional
public interface IAssetRequestRepository extends JpaRepository<AssetRequest, Integer> {

	@Modifying
	@Query(value="insert into asset_request(employee_id,asset_no) values(?1,?2)",nativeQuery = true)
	int addAssetRequest(int employeeId, int assetNo);

	List<AssetRequest> findAllByEmployee_EmployeeId(int employeeId);

	List<AssetRequest> findAllByRequestId(int requestId);

	List<AssetRequest> findAllByStatus(String status);

	@Modifying
	@Query(value="update asset_request set status=?2 where asset_no=?1",nativeQuery = true)
	int updateAssetStatus(int assetNo, String status);

}
