package org.care.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import org.care.dto.StoreDTO;

@Repository
public class StoreRegisterMapperImpl implements StoreRegisterMapper {

	@Inject SqlSession sql;
	// 매장등록

	@Override
	public void storeRegister(StoreDTO dto) throws Exception {
		sql.insert("StoreRegisterMapper.StoreRegister", dto);
	}
}
