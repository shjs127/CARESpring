package org.care.service;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface StoreService {
	
	public void store(StoreDTO storeDTO) throws Exception;

	public void changeInfo(StoreInfo sInfo);

}
