package org.care.service;

import java.util.List;

import org.care.domain.BoardInfo;
import org.care.dto.BoardDTO;

public interface ListArticleService {

  public List<BoardInfo> board(BoardDTO dto) throws Exception;



	
}
