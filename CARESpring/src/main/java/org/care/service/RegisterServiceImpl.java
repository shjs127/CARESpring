package org.care.service;

import javax.inject.Inject;

import org.care.dto.LoginDTO;
import org.care.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Inject RegisterMapper registerMapper;
	
	@Override
	public void register(LoginDTO dto) throws Exception {
		
		registerMapper.register(dto);
		
	}
	
	// 아이디 중복 체크
	@Override
	public int idChk(LoginDTO dto) throws Exception {
		int result = registerMapper.idChk(dto);
		return result;
	}
	
}