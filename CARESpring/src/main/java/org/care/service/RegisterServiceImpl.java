package org.care.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.care.domain.RegisterInfo;
import org.care.mapper.RegisterMapper;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Inject RegisterMapper registerMapper;
	
	@Override
	public void register(RegisterInfo registerInfo) throws Exception {
		
		registerMapper.register(registerInfo);
		
	}
	
}