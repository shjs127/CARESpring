package org.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface ListStoreMapper {
	
	public StoreInfo read(Integer storeNo) throws Exception;
	
	public List<StoreInfo> listAll() throws Exception;
	
	public List<StoreInfo> listPage(int page) throws Exception;
	
	public List<StoreInfo> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<StoreInfo> listSearchDetail(@Param("cri") SearchCriteria cri, @Param("valueArr") List<String> valueArr) throws Exception;
	
	public int listSearchDetailCount(@Param("cri") SearchCriteria cri, @Param("valueArr") List<String> valueArr) throws Exception;
	
	public List<StoreDTO> topList(StoreDTO dto);

	public List<StoreDTO> reviewTop(StoreDTO dto);
}
