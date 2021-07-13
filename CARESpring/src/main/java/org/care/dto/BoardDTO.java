package org.care.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int boardNo;
	private int userNo;
	private String boardTitle;
	private String boardContents;
	private int viewCount;
	private Date boardDate;
}
