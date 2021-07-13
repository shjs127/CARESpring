package org.care.mapper;

import java.util.List;

import org.care.domain.BoardInfo;

public interface BoardListMapper {
	List<BoardInfo> selectBoardList() throws Exception;
}
