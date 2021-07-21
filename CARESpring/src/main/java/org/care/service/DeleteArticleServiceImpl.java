package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteArticleServiceImpl implements DeleteArticleService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public void delete(BoardDTO dto) throws Exception {
		boardListMapper.deletePic(dto);
		boardListMapper.delete(dto);
	}

	@Override
	public BoardPicInfo getBoardPic(BoardDTO dto) throws Exception {
		
		return boardListMapper.getBoardPic(dto);
	}
	
	

}