package com.example.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.CountryEntity;
import com.example.api.entity.CountryMapping;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{
	Page<CountryMapping> findAllBy(Pageable pageable);
}
