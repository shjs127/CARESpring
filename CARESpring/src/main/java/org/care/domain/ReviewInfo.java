package org.care.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewInfo {

	private int reviewNo;
	private int userNo;
	private int storeNo;
	private double avgScore;
	private String reviewContents;
	private Date reviewDate;
	private String nickName;
	
}
