package org.care.domain;

import java.util.Date;

public class RegisterInfo {

	private int userNo;
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
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdminister() {
		return administer;
	}
	public void setAdminister(String administer) {
		this.administer = administer;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getSessionLimit() {
		return sessionLimit;
	}
	public void setSessionLimit(String sessionLimit) {
		this.sessionLimit = sessionLimit;
	}
	
	@Override
	public String toString() {
		return "RegisterInfo [userNo=" + userNo + " , userId=" + userId + ", Password=" + password + ", userName=" + userName + ", nickName="
				+ nickName + " , birth=" + birth + " , email=" + email + " , gender=" + gender + " administer=" + administer + " , sessionKey="+ sessionKey + ", sessionLimit="+ sessionLimit + "]";
	}
	
}

	
		