package org.care.service;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public void store(StoreDTO storeDTO) throws Exception {
		
		StoreDTO sDTO = storeMapper.selectByStore(storeDTO);
		
		if(sDTO == null) {
			storeMapper.insert(storeDTO);
		}else {
			storeMapper.update(storeDTO);
		}	
		
	}

}
