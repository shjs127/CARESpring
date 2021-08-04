package org.care.mapper;

import java.util.List;

import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface ListStoreMapper {
	
	public StoreInfo read(Integer storeNo) throws Exception;
	
	public List<StoreInfo> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<StoreInfo> listSearchDetail(SearchCriteria cri) throws Exception;
	
	public int listSearchDetailCount(SearchCriteria cri) throws Exception;
	
	public List<StoreDTO> topList(StoreDTO dto);

	public List<StoreDTO> reviewTop(StoreDTO dto);
}
