package org.care.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.ArticlePage;
import org.care.domain.BoardInfo;
import org.care.dto.BoardDTO;

public interface ListArticleService {

  public List<BoardInfo> board(BoardDTO dto) throws Exception;

  public ArticlePage getArticlePage(int pageNo, int pageV, @Param("searching") String searching) throws Exception;

	
}
