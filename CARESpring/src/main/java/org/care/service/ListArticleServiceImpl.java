package org.care.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.ArticlePage;
import org.care.domain.BoardInfo;
import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListArticleServiceImpl implements ListArticleService {

	@Autowired
	private BoardListMapper boardListMapper;


	@Override
	public ArticlePage getArticlePage(int pageNo, int pageV, String searching) throws Exception {
		
		int endSize = pageNo * pageV;
		int page = (pageNo - 1) * pageV + 1;
		
		int total = boardListMapper.searchCount(searching);
		List<BoardInfo> boardList = boardListMapper.search(page, endSize, searching);
		
		return new ArticlePage(total, pageNo, pageV, boardList);
	}


	@Override
	public List<BoardDTO> boardTop(BoardDTO bdto) throws Exception{
		return boardListMapper.boardTop(bdto);
	}


	@Override
	public List<BoardPicInfo> getBoardPic(List<BoardDTO> boardTop) throws Exception {
		return boardListMapper.getBoardPicList(boardTop);
	}
	
	
}

