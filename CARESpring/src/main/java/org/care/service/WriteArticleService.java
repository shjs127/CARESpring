package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;

public interface WriteArticleService {

  public void writeArticle(BoardDTO dto) throws Exception;
  
  public void writePic(BoardPicInfo pic) throws Exception;

  public void writePicNull(BoardDTO dto) throws Exception;
	
}
