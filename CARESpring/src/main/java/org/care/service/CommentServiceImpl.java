package org.care.service;

import java.util.List;

import org.care.domain.CommentInfo;
import org.care.dto.BoardDTO;
import org.care.dto.CommentDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public void insertComment(BoardDTO dto, String comment) throws Exception {
		 boardListMapper.insertComment(dto, comment);
	}
	
	@Override
	public List<CommentInfo> getComment(BoardDTO bno) throws Exception {
		
		return boardListMapper.getComment(bno);
	}
	
	@Override
	public void deleteComment(CommentDTO dto) throws Exception {
		
		boardListMapper.deleteComment(dto);
	}

	@Override
	public void updateComment(CommentDTO dto) throws Exception {
		boardListMapper.updateComment(dto);
	}
}