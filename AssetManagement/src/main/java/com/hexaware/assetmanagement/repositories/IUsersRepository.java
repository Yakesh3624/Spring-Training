package com.hexaware.assetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

}
