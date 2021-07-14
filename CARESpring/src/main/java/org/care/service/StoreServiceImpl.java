package org.care.service;

import java.util.List;

import javax.inject.Inject;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	public StoreMapper storeMapper;

	@Override
	public List<StoreInfo> selectStore(StoreDTO dto) throws Exception {
		return storeMapper.selectStore(dto);
	}

	@Override
	public StoreInfo login(StoreDTO dto) throws Exception {

		return storeMapper.storeLogin(dto);
	}

  }
  
	
	 

