package org.care.service;

import org.care.dto.LoginDTO;

public interface RegisterService {
	
	public void register(LoginDTO dto) throws Exception;
	
	public int idChk(LoginDTO dto) throws Exception;

}
