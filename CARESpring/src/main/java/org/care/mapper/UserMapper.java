package org.care.mapper;

import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;

public interface UserMapper {
	UserInfo selectUser(LoginDTO dto) throws Exception;
}
