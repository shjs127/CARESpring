package org.care.domain;

import java.util.List;

import lombok.Data;

@Data
public class BoardInfoList {
	private String fileName1;
	private List<BoardPicInfo> files;
	private int boardNo;
	
	public BoardInfoList(int boardNo, List<BoardPicInfo> files) {
		this.boardNo = boardNo;
		this.files = files;
	}
}

