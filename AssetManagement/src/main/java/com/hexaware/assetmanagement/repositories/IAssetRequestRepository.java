package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.AssetRequest;

public interface IAssetRequestRepository extends JpaRepository<AssetRequest, Integer> {

}
