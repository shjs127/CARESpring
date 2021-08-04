package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteArticleServiceImpl implements WriteArticleService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public void writeArticle(BoardDTO dto) throws Exception {

		boardListMapper.insert(dto);
	}

	@Override
	public void writePic(BoardPicInfo pic) throws Exception {
		boardListMapper.picInsert(pic);
	}

	@Override
	public void writePicNull(BoardDTO dto) throws Exception {

		boardListMapper.picInsertNull(dto);
	}
}