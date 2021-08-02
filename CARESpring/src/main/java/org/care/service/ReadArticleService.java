package org.care.service;

import java.util.List;

import org.care.domain.BoardInfo;
import org.care.domain.BoardInfoList;
import org.care.domain.CommentInfo;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;
import org.care.domain.UserInfo;
import org.care.dto.BoardDTO;

public interface ReadArticleService {
	
	public BoardInfo getArticle(BoardDTO dto) throws Exception;

	public BoardInfoList view(BoardDTO dto) throws Exception;
	
	public NextNo nextView(BoardDTO dto) throws Exception;
	
	public PrevNo prevView(BoardDTO dto) throws Exception;
	
	public UserInfo getName(BoardDTO dto) throws Exception;
	
}