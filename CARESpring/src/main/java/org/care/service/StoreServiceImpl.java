package org.care.service;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreServiceImpl implements StoreService {

  @Autowired
  private StoreMapper storeMapper;

  @Override
  @Transactional
  public StoreInfo storeInfo(StoreDTO dto) throws Exception {

    return storeMapper.selectStore(dto);
  }
  
	
	 
}
