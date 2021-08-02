package org.care.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO {

	private int boardNo;
	private int commentNo;
	private int userNo;
	private String commentContents;
	private Date commentDate;
	private String nickName;
}
