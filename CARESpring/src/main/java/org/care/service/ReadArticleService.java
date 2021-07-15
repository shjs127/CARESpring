package org.care.service;

import org.care.domain.BoardInfo;
import org.care.domain.BoardInfoList;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;

public interface ReadArticleService {
	
	public BoardInfo getArticle(int boardNo) throws Exception;

	public BoardInfoList view(int boardNo) throws Exception;
	
	public NextNo nextView(int boardNo) throws Exception;
	
	public PrevNo prevView(int boardNo) throws Exception;
}