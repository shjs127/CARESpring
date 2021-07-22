package org.care.mapper;

import org.care.dto.LoginDTO;

public interface RegisterMapper {
	
	// 회원가입
	public void register(LoginDTO dto) throws Exception;

}
