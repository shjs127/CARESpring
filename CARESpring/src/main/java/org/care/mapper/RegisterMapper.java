package org.care.mapper;

import org.care.dto.LoginDTO;

public interface RegisterMapper {
	
	// ȸ������
	public void register(LoginDTO dto) throws Exception;
	
	// ���̵� �ߺ�üũ
	public int idChk(LoginDTO dto) throws Exception;

}
