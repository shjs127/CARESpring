package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyArticleServiceImpl implements ModifyArticleService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public void update(BoardDTO dto) throws Exception {
		boardListMapper.update(dto);
	}

	@Override
	public void updatePic(BoardPicInfo pic) throws Exception {
		boardListMapper.updatePic(pic);
	}

}