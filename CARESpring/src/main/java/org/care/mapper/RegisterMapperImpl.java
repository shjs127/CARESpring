package org.care.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.care.domain.RegisterInfo;

@Repository
public class RegisterMapperImpl implements RegisterMapper {

	@Inject SqlSession sql;
	// 회원가입

	@Override
	public void register(RegisterInfo registerInfo) throws Exception {
		sql.insert("RegisterMapper.register", registerInfo);
	}
}
