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
	public List<StoreInfo> listCriteria(Criteria cri) throws Exception {
		return listStoreMapper.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return listStoreMapper.countPaging(cri);
	}

	@Override
	public List<StoreInfo> listSearch(SearchCriteria cri) throws Exception {
		return null;
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return 0;
	}

	@Override
	public List<StoreInfo> readPage(Integer storeNo) throws Exception {
		return (List<StoreInfo>) listStoreMapper.read(storeNo);
	}

	@Override
	public List<StoreDTO> listTop(StoreDTO dto) {
		return listStoreMapper.topList(dto);
		
	}
}
