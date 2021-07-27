package org.care.service;

import org.care.dto.StoreDTO;
import org.care.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public void store(StoreDTO storeDTO) throws Exception {
		
		storeDTO = storeMapper.selectByStore(storeDTO);
		String str = storeDTO.getManageNo();
	
		if(str == null) {
			storeMapper.insert(storeDTO);
		}else {
			storeMapper.update(storeDTO);
		}
		
	}
}
