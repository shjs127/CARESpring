package org.care.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.care.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterMapperImpl implements RegisterMapper {

	@Inject SqlSession sql;
	// ȸ������

	@Override
	public void register(LoginDTO dto) throws Exception {
		sql.insert("RegisterMapper.register", dto);
	}
	
	// ���̵� �ߺ� üũ
	@Override
	public int idChk(LoginDTO dto) throws Exception {
		int result = sql.selectOne("RegisterMapper.idChk", dto);
		return result;
	}
}
