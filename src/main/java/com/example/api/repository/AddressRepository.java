package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.AddressEntity;
import com.example.api.entity.CityEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
	// List<AddressEntity> findAll();
	
	Long countByCityEntity(CityEntity cityEntity);
	// select count(*) from address city_id cityEntity.getCityId()
}
