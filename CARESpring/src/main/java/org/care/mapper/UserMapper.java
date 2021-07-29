package org.care.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.dto.ReviewDTO;

public interface UserMapper {
	UserInfo selectUser(LoginDTO dto) throws Exception;

	void keepLogin(String userId, String sessionId, Date next);

	UserInfo checkUserWithSessionKey(String value);

	void changeInfo(LoginDTO uInfo);

	List<ReviewDTO> selectReviewUser(int userNo);
}
