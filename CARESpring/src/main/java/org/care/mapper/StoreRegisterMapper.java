package org.care.mapper;

import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;

public interface StoreRegisterMapper {
	
	// ���� ���
	public void storeRegister(StoreDTO dto) throws Exception;
	public void detailRegister(DetailDTO ddto) throws Exception;

}
