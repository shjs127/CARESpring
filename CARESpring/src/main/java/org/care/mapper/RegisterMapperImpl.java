package org.care.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.care.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterMapperImpl implements RegisterMapper {

	@Inject SqlSession sql;
	// 회원가입

	@Override
	public void register(LoginDTO dto) throws Exception {
		sql.insert("RegisterMapper.register", dto);
	}
	
	// 아이디 중복 체크
	@Override
	public int idChk(LoginDTO dto) throws Exception {
		int result = sql.selectOne("RegisterMapper.idChk", dto);
		return result;
	}
}
