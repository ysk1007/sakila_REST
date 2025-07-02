package com.example.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dto.CityDto;
import com.example.api.entity.CityEntity;
import com.example.api.entity.CityMapping;
import com.example.api.entity.CountryEntity;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.CityRepository;
import com.example.api.repository.CountryRepository;

@Service
@Transactional
public class CityService {
	private CityRepository cityRepository;
	private CountryRepository countryRepository;
	private AddressRepository addressRepository; 
	
	public CityService(CityRepository cityRepository, CountryRepository countryRepository, AddressRepository addressRepository) {
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.addressRepository = addressRepository;
	}
	
	// 삭제
	public boolean delete(int cityId) {
		if(addressRepository.countByCityEntity(cityRepository.findById(cityId).orElse(null)) > 0) {
			System.out.println("자식 테이블에 외래키로 참조하는 행이 존재합니다.");
			return false;
		}
		
		cityRepository.deleteById(cityId);
		return true;
	}
	
	// 수정
	public void update(CityDto cityDto) {	
		CityEntity updateCityEntity = cityRepository.findById(cityDto.getCityId()).orElse(null);
		updateCityEntity.setCity(cityDto.getCity());
		
		updateCityEntity.setCountryEntity(countryRepository.findById(cityDto.getCountryId()).orElse(null));
	}
	
	// 입력
	public void save(CityDto cityDto) {
		// DTO -> Entity		
	    CityEntity saveCityEntity = new CityEntity();	    
	    saveCityEntity.setCity(cityDto.getCity());
	    
	    CountryEntity saveCountryEntity = countryRepository.findById(cityDto.getCountryId()).orElse(null);
	    saveCityEntity.setCountryEntity(saveCountryEntity);
	    
	    cityRepository.save(saveCityEntity);
	}
	
	// 전체 조회
	public Page<CityMapping> findAll(int currentPage){
		int pageSize = 10;
		int pageNumber = currentPage - 1;
		
		Sort sort = Sort.by("cityId").ascending();
		PageRequest pagealbe = PageRequest.of(pageNumber, pageSize, sort);
		
		return cityRepository.findAllBy(pagealbe);
	}
	
	// 한행 조회
	public CityEntity findById(int cityId) {
		return cityRepository.findById(cityId).orElse(null);
	}
}
