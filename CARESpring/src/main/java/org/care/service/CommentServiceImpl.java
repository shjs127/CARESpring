package org.care.service;

import org.care.dto.BoardDTO;
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
}