package org.care.service;

import javax.inject.Inject;

import org.care.dto.StoreDTO;
import org.care.mapper.StoreRegisterMapper;
import org.springframework.stereotype.Service;

@Service
public class StoreRegisterServiceImpl implements StoreRegisterService {
	
	@Inject StoreRegisterMapper storeRegisterMapper;
	
	@Override
	public void storeRegister(StoreDTO dto) throws Exception {
		
		storeRegisterMapper.storeRegister(dto);
		
	}
	
}