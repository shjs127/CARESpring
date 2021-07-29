package org.care.service;

import java.util.Date;
import java.util.List;

import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.dto.ReviewDTO;

public interface UserService {

  public UserInfo login(LoginDTO dto) throws Exception;

	
	  public void keepLogin(String uid, String sessionId, Date next)throws Exception;
	  
	  public UserInfo checkLoginBefore(String value);
	  
	  public void changeInfo(LoginDTO uInfo);


	public List<ReviewDTO> selectReviewUser(int userNo);
	 
}
