package org.care.domain;


import lombok.Data;

@Data
public class UserInfo {

	private Integer userNo;
	private String userId;
	private String password;
	private String userName;
	private String nickName;
	private String birth;
	private String email;
	private String gender;
	private String administer;
	private String sessionKey;
	private String sessionLimit;
}
