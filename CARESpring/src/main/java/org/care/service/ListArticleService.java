package org.care.service;

import java.util.List;

import org.care.domain.ArticlePage;
import org.care.dto.BoardDTO;


public interface ListArticleService {

  public ArticlePage getArticlePage(int pageNo, int pageV, String searching) throws Exception;

public List<BoardDTO> boardTop(BoardDTO bdto)throws Exception;

	
}
