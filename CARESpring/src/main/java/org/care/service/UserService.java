package org.care.service;

import java.util.Date;

import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;

public interface UserService {

  public UserInfo login(LoginDTO dto) throws Exception;

	/*
	 * public void keepLogin(String uid, String sessionId, Date next)throws
	 * Exception;
	 * 
	 * public UserInfo checkLoginBefore(String value);
	 */
}
