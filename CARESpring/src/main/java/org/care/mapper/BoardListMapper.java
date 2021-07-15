package org.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.BoardInfo;
import org.care.domain.BoardPicInfo;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;

public interface BoardListMapper {
	List<BoardInfo> selectBoardList() throws Exception;
	
	int searchCount(@Param("searching") String searching) throws Exception;
	
	List<BoardInfo> search(@Param("page")int page, @Param("endSize")int endSize, @Param("searching") String searching) throws Exception;
	
	BoardInfo selectById(@Param("boardNo")int boardNo) throws Exception;
	
	int increaseReadCount(@Param("boardNo") int boardNo) throws Exception;
	
	List<BoardPicInfo> selectByBoardNo(@Param("boardNo") int boardNo) throws Exception;
	
	NextNo nextView(@Param("boardNo") int boardNo) throws Exception;
	
	PrevNo prevView(@Param("boardNo") int boardNo) throws Exception;
}
