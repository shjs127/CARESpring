package org.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.BoardInfo;
import org.care.domain.BoardPicInfo;
import org.care.domain.CommentInfo;
import org.care.domain.NextNo;
import org.care.domain.PrevNo;
import org.care.domain.UserInfo;
import org.care.dto.BoardDTO;
import org.care.dto.CommentDTO;

public interface BoardListMapper {
	List<BoardInfo> selectBoardList() throws Exception;
	
	int searchCount(@Param("searching") String searching) throws Exception;
	
	List<BoardInfo> search(@Param("page")int page, @Param("endSize")int endSize, @Param("searching") String searching) throws Exception;
	
	BoardInfo selectById(BoardDTO dto) throws Exception;
	
	int increaseReadCount(BoardDTO dto) throws Exception;
	
	List<BoardPicInfo> selectByBoardNo(BoardDTO dto) throws Exception;
	
	NextNo nextView(BoardDTO dto) throws Exception;
	
	PrevNo prevView(BoardDTO dto) throws Exception;
	
	void insert(BoardDTO dto) throws Exception;
	
	void picInsert(BoardPicInfo pic) throws Exception;
	
	List<BoardPicInfo> picView(BoardDTO dto) throws Exception;
	
	UserInfo getName (@Param("userNo") int userNo) throws Exception;
	
	int getUserNo (BoardDTO dto) throws Exception;
	
	void update(BoardDTO dto) throws Exception;
	
	void updatePic(BoardPicInfo pic) throws Exception;

	List<BoardDTO> boardTop(BoardDTO dto)throws Exception;
	
	void deletePic(BoardDTO dto) throws Exception;
	
	void delete(BoardDTO dto) throws Exception;
	
	BoardPicInfo getBoardPic(BoardDTO dto) throws Exception;
	
	List<CommentInfo> getComment(BoardDTO dto) throws Exception;
	
	void insertComment(BoardDTO dto, String comment) throws Exception;
	
	void deleteComment(CommentDTO dto) throws Exception;
	
	void updateComment(CommentDTO dto) throws Exception;
	
	void commentAllDelete(BoardDTO dto) throws Exception;
}
