package org.care.service;

import java.util.List;

import org.care.domain.Criteria;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.mapper.ListStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListStoreServiceImpl implements ListStoreService {

	@Autowired
	private ListStoreMapper listStoreMapper;

	@Override
	public StoreInfo read(Integer storeNo) throws Exception {

		return listStoreMapper.read(storeNo);
	}

	@Override
	public List<StoreInfo> listAll() throws Exception {
		return listStoreMapper.listAll();
	}

	@Override
	public List<StoreInfo> listPage(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) + 10;
		
		return listStoreMapper.listPage(page);
	}

	@Override
	public List<StoreInfo> listSearch(SearchCriteria cri) throws Exception {
		return listStoreMapper.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return listStoreMapper.listSearchCount(cri);
	}

	@Override
	public List<StoreInfo> listSearchDetail(SearchCriteria cri, List<String> valueArr) throws Exception {
		System.out.println(valueArr);
		return listStoreMapper.listSearchDetail(cri, valueArr);
	}

	@Override
	public int listSearchDetailCount(SearchCriteria cri, List<String> valueArr) throws Exception {
		return listStoreMapper.listSearchDetailCount(cri, valueArr);
	}
	
	@Override
	public List<StoreInfo> readPage(Integer storeNo) throws Exception {
		return (List<StoreInfo>) listStoreMapper.read(storeNo);
	}

	@Override
	public List<StoreDTO> listTop(StoreDTO dto)throws Exception {
		return listStoreMapper.topList(dto);
		
	}

	@Override
	public List<StoreDTO> reviewTop(StoreDTO dto)throws Exception {
		return listStoreMapper.reviewTop(dto);
	}
}
