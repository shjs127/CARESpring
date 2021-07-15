package org.care.service;

import java.util.List;

import org.care.domain.BoardInfo;
import org.care.domain.BoardInfoList;
import org.care.domain.BoardPicInfo;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadArticleServiceImpl implements ReadArticleService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public BoardInfo getArticle(int boardNo) throws Exception {
			boardListMapper.increaseReadCount(boardNo);
		return boardListMapper.selectById(boardNo);
	}

	@Override
	public BoardInfoList view(int boardNo) throws Exception {
		List<BoardPicInfo> files = boardListMapper.selectByBoardNo(boardNo);
		System.out.println("files=" +files);
		BoardInfoList boardInfoList = new BoardInfoList(boardNo, files);
		return boardInfoList;
	}

	@Override
	public NextNo nextView(int boardNo) throws Exception {
		System.out.println("nextView = "+ boardListMapper.nextView(boardNo));
		return boardListMapper.nextView(boardNo);
	}

	@Override
	public PrevNo prevView(int boardNo) throws Exception {
		System.out.println("prevView = "+ boardListMapper.prevView(boardNo));
		return boardListMapper.prevView(boardNo);
	}
}