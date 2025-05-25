package com.hexaware.assetmanagement.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.assetmanagement.entities.AssetAllocation;

import jakarta.transaction.Transactional;

@Transactional
public interface IAssetAllocationRepository extends JpaRepository<AssetAllocation,Integer> {

	@Query(value="insert into asset_allocation(employee_id,asset_no,return_date) values(?1,?2,?3)",nativeQuery = true)
	AssetAllocation allocateAssetToEmployee(int employeeId, int assetNo, LocalDate returnDate);

	List<AssetAllocation> findAllByEmployee_EmployeeId(int employeeId);

	@Modifying
	@Query(value="update asset set status='available' where assetNo = (select allocationId from asset_allocation where allocationId = ?1)",nativeQuery = true)
	int returnAsset(int allocationId);

}
