package org.care.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.care.domain.UserInfo;
import org.care.mapper.RegisterMapper;

@Service
public class RegisterServiceImpl implements RegisterService {
	private final RegisterMapper registerMapper;

	@Inject
	public RegisterServiceImpl(RegisterMapper registerMapper) { 
		this.registerMapper = registerMapper;
	}
	
	// 회원 가입 처리
	@Override 
	public void register(UserInfo userInfo) throws Exception {
	 registerMapper.register(userInfo);
}
}