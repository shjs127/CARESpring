package org.care.mapper;

import org.care.dto.StoreDTO;

public interface StoreMapper {

	public StoreDTO selectByStore(StoreDTO storeDTO);
	
	public StoreDTO insert(StoreDTO storeDTO);
	
	public StoreDTO update(StoreDTO storeDTO);
}
