package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.AssetAllocation;

public interface IAssetAllocationRepository extends JpaRepository<AssetAllocation,Integer> {

}
