package org.care.mapper;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface StoreMapper {
	StoreInfo selectStore(StoreDTO dto) throws Exception;
}
