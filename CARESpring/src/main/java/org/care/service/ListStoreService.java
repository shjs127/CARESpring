package org.care.service;

import java.util.List;

import org.care.domain.Criteria;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface ListStoreService {

	public List<StoreInfo> readPage(Integer storeNo) throws Exception;
	
	public StoreInfo read(Integer storeNo) throws Exception;

	public List<StoreInfo> listAll() throws Exception;
	
	public List<StoreInfo> listPage(int page) throws Exception;
	 
	public List<StoreInfo> listCriteria(Criteria cri) throws Exception;
	 
	public int countPaging(Criteria cri) throws Exception;
	 
	public List<StoreInfo> listSearch(SearchCriteria cri) throws Exception;
	  
	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<StoreDTO> listTop(StoreDTO dto);

	public List<StoreDTO> reviewTop(StoreDTO dto);
 
}
