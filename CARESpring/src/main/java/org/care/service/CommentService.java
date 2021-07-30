package org.care.service;

import org.care.domain.CommentInfo;
import org.care.dto.BoardDTO;

public interface CommentService {

  public void insertComment(BoardDTO dto, String comment) throws Exception;
}
