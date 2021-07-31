package org.care.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentInfo {

	private int boardNo;
	private int commentNo;
	private int userNo;
	private String commentContents;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss" )
	private Date commentDate;
}
