package org.care.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardInfo {

	private int boardNo;
	private int userNo;
	private String boardTitle;
	private String boardContents;
	private int viewCount;
	private Date boardDate;
}
