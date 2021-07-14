package org.care.mapper;

import java.util.List;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface StoreMapper {
	List<StoreInfo> selectStore(StoreDTO dto) throws Exception;

	StoreInfo storeLogin(StoreDTO dto) throws Exception;
}
//