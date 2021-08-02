package org.care.service;

import java.util.List;

import org.care.domain.CommentInfo;
import org.care.dto.BoardDTO;
import org.care.dto.CommentDTO;

public interface CommentService {

	public void insertComment(BoardDTO dto, String comment) throws Exception;

	public List<CommentInfo> getComment(BoardDTO dto) throws Exception;

	public void deleteComment(CommentDTO dto) throws Exception;
	
	public void updateComment(CommentDTO dto) throws Exception;
}
