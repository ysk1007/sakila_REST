package com.example.api.repository;

import java.util.List;

import com.example.api.entity.CountryEntity;

import org.springframework.data.jpa.repository.*;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{
	// List<CountryEntity> findAll();
}
