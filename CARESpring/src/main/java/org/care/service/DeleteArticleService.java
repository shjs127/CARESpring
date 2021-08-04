package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;

public interface DeleteArticleService {

  public void delete(BoardDTO dto) throws Exception;
  
  public BoardPicInfo getBoardPic(BoardDTO dto) throws Exception;
  
  public void deletePic(BoardDTO dto) throws Exception;
}
