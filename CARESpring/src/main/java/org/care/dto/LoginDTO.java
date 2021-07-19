package org.care.dto;

import lombok.Data;

@Data
public class LoginDTO {
	
	private int userNo;
	private String userId;
	private String password;
	private String name;
	private String nickName;
	private boolean UseCookie;
	private String userName;
	private String newPassword;
	private String birth;
	private String email;
	private String gender;
}
