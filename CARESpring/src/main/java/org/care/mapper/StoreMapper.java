package org.care.mapper;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface StoreMapper {

	public StoreDTO selectByStore(StoreDTO storeDTO);
	
	public StoreDTO insert(StoreDTO storeDTO);
	
	public StoreDTO update(StoreDTO storeDTO);

	public void changeInfo(StoreInfo sInfo);
}
