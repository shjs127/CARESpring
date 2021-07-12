package org.care.domain;


import lombok.Data;

@Data
public class UserInfo {

	private int userNo;
	private String userId;
	private String password;
	private String name;
	private String nickName;
	private String birth;
	private String email;
	private String gender;
	private String administer;

}
