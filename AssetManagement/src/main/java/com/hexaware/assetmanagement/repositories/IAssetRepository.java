package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.Asset;

public interface IAssetRepository extends JpaRepository<Asset, Integer> {

}
