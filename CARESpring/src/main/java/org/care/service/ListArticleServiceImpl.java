package org.care.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.ArticlePage;
import org.care.domain.BoardInfo;
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
	
	
}

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
