package org.care.mapper;

import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;

public interface StoreRegisterMapper {
	
	// 매장 등록
	public void storeRegister(StoreDTO dto) throws Exception;
	public void detailRegister(DetailDTO ddto) throws Exception;

}
