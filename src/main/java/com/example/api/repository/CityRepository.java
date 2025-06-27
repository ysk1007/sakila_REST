package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.CityEntity;
import com.example.api.entity.CountryEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	// List<CityEntity> findAll();
	
	Long countByCountryEntity(CountryEntity countryEntity);
	// select count(*) from city country_id countryEntity.getCountryId()
}
