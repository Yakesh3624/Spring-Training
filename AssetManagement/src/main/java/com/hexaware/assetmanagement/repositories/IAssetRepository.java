package com.hexaware.assetmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.Asset;

public interface IAssetRepository extends JpaRepository<Asset, Integer> {

	List<Asset> findAllByCategory(String category);

}
