package com.example.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dto.CountryDto;
import com.example.api.entity.CountryEntity;
import com.example.api.repository.CityRepository;
import com.example.api.repository.CountryRepository;

@Service
@Transactional
public class CountryService {

    private CityRepository cityRepository;
	private CountryRepository countryRepository;

	// 필드주입 대신 생성자 주입을 사용
	public CountryService(CountryRepository countryRepository, CityRepository cityRepository) {
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
	}
	
	// country 삭제
	public boolean delete(int countryId) {
		// 자식테이블에 외래키로 참조하는 행이 있다면?
		if(cityRepository.countByCountryEntity(countryRepository.findById(countryId).orElse(null)) > 0) {
			System.out.println("자식 테이블에 외래키로 참조하는 행이 존재합니다.");
			return false;
		}
		
		countryRepository.deleteById(countryId);
		return true;
	}
	
	// country 수정
	public void update(CountryDto countryDto) {
		CountryEntity updateCountryEntity = countryRepository.findById(countryDto.getCountryId()).orElse(null);
		updateCountryEntity.setCountry(countryDto.getCountry());
	}
	
	// CountryEntity 입력
	public void save(CountryDto countryDto) {
		CountryEntity saveCountryEntity = new CountryEntity();
		saveCountryEntity.setCountry(countryDto.getCountry());
		countryRepository.save(saveCountryEntity);
	}
	
	// 조회
	public List<CountryEntity> findAll(){
		return countryRepository.findAll();
	}
	
}
