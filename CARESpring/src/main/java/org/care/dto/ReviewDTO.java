package org.care.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int reviewNo;
	private int userNo;
	private int storeNo;
	private int avgScore;
	private String reviewContents;
	private Date reviewDate;
	
	
}
