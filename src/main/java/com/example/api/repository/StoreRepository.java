package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer>{
	
}
