package org.care.service;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	public FoodMapper foodMapper;

	@Override
	public List<StoreInfo> selectStore(StoreDTO dto) throws Exception {
		return foodMapper.selectStore(dto);
	}

	@Override
	public StoreInfo login(StoreDTO dto) throws Exception {

		return foodMapper.storeLogin(dto);
	}
	

	@Override
	public List<DetailInfo> selectDetail(DetailDTO dto) throws Exception {
			
		return foodMapper.selectDetail(dto);
		
	}
		
	
}
  
  
	
	 

