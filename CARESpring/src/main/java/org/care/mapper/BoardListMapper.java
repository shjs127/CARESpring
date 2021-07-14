package org.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.BoardInfo;

public interface BoardListMapper {
	List<BoardInfo> selectBoardList() throws Exception;
	
	int searchCount(@Param("searching") String searching) throws Exception;
	
	List<BoardInfo> search(int page, int endSize, @Param("searching") String searching) throws Exception;
	
}
