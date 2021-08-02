package org.care.service;

import java.util.List;

import org.care.domain.BoardInfo;
import org.care.domain.BoardInfoList;
import org.care.domain.BoardPicInfo;
import org.care.domain.CommentInfo;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;
import org.care.domain.UserInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadArticleServiceImpl implements ReadArticleService {



	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public BoardInfo getArticle(BoardDTO dto) throws Exception {
			boardListMapper.increaseReadCount(dto);
		return boardListMapper.selectById(dto);
	}

	@Override
	public BoardInfoList view(BoardDTO dto) throws Exception {
		List<BoardPicInfo> files = boardListMapper.picView(dto);
		System.out.println("files=" +files);
		BoardInfoList boardInfoList = new BoardInfoList(dto.getBoardNo(), files);
		return boardInfoList;
	}

	@Override
	public NextNo nextView(BoardDTO dto) throws Exception {
		return boardListMapper.nextView(dto);
	}

	@Override
	public PrevNo prevView(BoardDTO dto) throws Exception {
		return boardListMapper.prevView(dto);
	}
	
	public UserInfo getName(BoardDTO dto) throws Exception {
		
		int userNo = boardListMapper.getUserNo(dto);
		return boardListMapper.getName(userNo);
	}
	
}