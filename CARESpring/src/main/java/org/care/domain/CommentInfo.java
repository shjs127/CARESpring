package org.care.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentInfo {

	private int boardNo;
	private int commentNo;
	private int userNo;
	private String commentContents;
	private Date commentDate;
}
