package org.care.service;

import javax.inject.Inject;

import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.mapper.StoreRegisterMapper;
import org.springframework.stereotype.Service;

@Service
public class StoreRegisterServiceImpl implements StoreRegisterService {
	
	@Inject StoreRegisterMapper storeRegisterMapper;
	
	@Override
	public void storeRegister(StoreDTO dto , DetailDTO ddto) throws Exception {
		
		storeRegisterMapper.storeRegister(dto);
		int storeNo = dto.getStoreNo();
		ddto.setStoreNo(storeNo);
		storeRegisterMapper.detailRegister(ddto);
		
	}

	
	
}