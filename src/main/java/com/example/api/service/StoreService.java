package com.example.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dto.StoreDto;
import com.example.api.entity.StoreEntity;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.StoreRepository;

@Service
@Transactional
public class StoreService {
	private StoreRepository storeRepository;
	private AddressRepository addressRepository;
	
	public StoreService(StoreRepository storeRepository,AddressRepository addressRepository) {
		this.storeRepository = storeRepository;
		this.addressRepository = addressRepository;
	}
	
	// 전체 조회
	public List<StoreEntity> findAll(){
		return storeRepository.findAll();
	}
	
	// 한행 조회
	public StoreEntity findById(int storeId) {
		return storeRepository.findById(storeId).orElse(null);
	}
	
	// 삽입
	public void save(StoreDto storeDto) {
		StoreEntity saveStoreEntity = new StoreEntity();
		saveStoreEntity.setManagerStaffId(storeDto.getManagerStaffId());
		saveStoreEntity.setAddressEntity(addressRepository.findById(storeDto.getAddressId()).orElse(null));
		storeRepository.save(saveStoreEntity);
	}
	
	// 수정
	public void update(StoreDto storeDto) {
		StoreEntity saveStoreEntity = storeRepository.findById(storeDto.getStoreId()).orElse(null);
		saveStoreEntity.setManagerStaffId(storeDto.getManagerStaffId());
		saveStoreEntity.setAddressEntity(addressRepository.findById(storeDto.getAddressId()).orElse(null));
	}
	
	// 삭제
	public void delete(int storeId) {
		storeRepository.deleteById(storeId);
	}
}
