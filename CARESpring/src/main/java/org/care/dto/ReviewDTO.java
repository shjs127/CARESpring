package org.care.dto;

import java.util.Date;
import lombok.Data;


@Data
public class ReviewDTO {

	public String getpFile() {
		return pFile;
	}
	public void setpFile(String pFile) {
		this.pFile = pFile;
	}
	private int reviewNo;
	private int userNo;
	private int storeNo;
	private double avgScore;
	private String reviewContents;
	private Date reviewDate;
	private String nickName;
	private String pFile;
	private String storeName;

	
	
}
