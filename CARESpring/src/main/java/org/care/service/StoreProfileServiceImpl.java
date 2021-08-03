package org.care.service;

import org.care.domain.DetailInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreProfileServiceImpl implements StoreProfileService{
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public void changeInfo(StoreInfo sInfo) {
		storeMapper.changeInfo(sInfo);
		
	}

	@Override
	public DetailInfo selectDetail(DetailInfo dInfo) {
		return storeMapper.selectDetail(dInfo);
	}

	@Override
	public void changeDetail(DetailDTO dto) {
		storeMapper.changeDetail(dto);
		
	}
}
