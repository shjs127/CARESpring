package org.care.service;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;

public interface ModifyArticleService {

	public void update(BoardDTO dto) throws Exception;
	
	public void updatePic(BoardPicInfo pic) throws Exception;
	
	public void updatePicNull(BoardDTO pic) throws Exception;
	
}
