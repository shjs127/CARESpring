package org.care.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;

public interface UserMapper {
	UserInfo selectUser(LoginDTO dto) throws Exception;

	void keepLogin(String userId, String sessionId, Date next);

	UserInfo checkUserWithSessionKey(String value);

	void changeInfo(LoginDTO uInfo);
}
