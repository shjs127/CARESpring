package org.care.mapper;

import org.care.domain.RegisterInfo;

public interface RegisterMapper {
	
	// 회원가입
	public void register(RegisterInfo registerInfo) throws Exception;

}
