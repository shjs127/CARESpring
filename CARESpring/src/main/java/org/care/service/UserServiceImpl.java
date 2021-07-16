package org.care.service;

import java.util.Date;

import javax.inject.Inject;

import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserMapper userMapper;

	@Override
	@Transactional
	public UserInfo login(LoginDTO dto) throws Exception {

		return userMapper.selectUser(dto);
	}

	@Override
	public void keepLogin(String userId, String sessionId, Date next) throws Exception {

		 userMapper.keepLogin(userId, sessionId, next);

	}

	@Override public UserInfo checkLoginBefore(String value) {
	  
	  return userMapper.checkUserWithSessionKey(value); 
	  
	}

	@Override
	public void changeInfo(UserInfo uInfo,String password,String nickName,String birth,String email) {
		userMapper.changeInfo(uInfo,password,nickName,birth,email);
		
	}
	 
	 
}
