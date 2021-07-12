package org.care.service;

import java.util.Date;

import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  @Transactional
  public UserInfo login(LoginDTO dto) throws Exception {

    return userMapper.selectUser(dto);
  }
  
	/*
	 * @Override public void keepLogin(String uid, String sessionId, Date next)
	 * throws Exception {
	 * 
	 * dao.keepLogin(uid, sessionId, next);
	 * 
	 * }
	 * 
	 * @Override public UserVO checkLoginBefore(String value) {
	 * 
	 * return dao.checkUserWithSessionKey(value); }
	 */
	 
}
