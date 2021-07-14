package org.care.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.ArticlePage;
import org.care.domain.BoardInfo;
import org.care.dto.BoardDTO;
import org.care.mapper.BoardListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListArticleServiceImpl implements ListArticleService {

	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public List<BoardInfo> board(BoardDTO dto) throws Exception {
		return boardListMapper.selectBoardList();
	}

	@Override
	public ArticlePage getArticlePage(int pageNo, int pageV, @Param("searching") String searching) throws Exception {
		
		int endSize = pageNo * pageV;
		int page = (pageNo - 1) * pageV + 1;
		
		int total = boardListMapper.searchCount(searching);
		List<BoardInfo> boardList = boardListMapper.search(page, endSize, searching);
		
		return new ArticlePage(total, pageNo, pageV, boardList);
	}
	
	
}

// private BoardInfoDao boardInfoDao = new BoardInfoDao();
//	private int endSize = 0;
//
//	public ArticlePage getArticlePage(int pageNum, int pageV, String search) {
//		
//		endSize = pageNum * pageV;
//		
//		try (Connection conn = ConnectionProvider.getConnection()) {
//			int total = boardInfoDao.searchCount(conn, search);
//			List<BoardInfo> boardList = boardInfoDao.search(conn, (pageNum - 1) * pageV + 1, endSize, search);
//			return new ArticlePage(total, pageNum, pageV, boardList);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}

//	public List<Board> boardTop(int top) {
//		
//		try (Connection conn = ConnectionProvider.getConnection()) {
//			List<Board> boardTop = boardInfoDao.boardViewTop(conn,top);
//	
//			return boardTop;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
