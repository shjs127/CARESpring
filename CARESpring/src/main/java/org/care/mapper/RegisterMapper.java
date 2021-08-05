package org.care.mapper;

import org.care.dto.LoginDTO;

public interface RegisterMapper {
	
	// 회원가입
	public void register(LoginDTO dto) throws Exception;
	
	// 아이디 중복체크
	public int idChk(LoginDTO dto) throws Exception;

}
