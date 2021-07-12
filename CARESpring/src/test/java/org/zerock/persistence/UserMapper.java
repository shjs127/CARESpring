package org.zerock.persistence;

import java.util.List;

import org.care.domain.UserInfo;

public interface UserMapper {
	UserInfo selectUser() throws Exception;
}
