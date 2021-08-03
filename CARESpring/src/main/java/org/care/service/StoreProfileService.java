package org.care.service;

import org.care.domain.DetailInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;

public interface StoreProfileService {

	public void changeInfo(StoreInfo sInfo);

	public DetailInfo selectDetail(DetailInfo dInfo);

	public void changeDetail(DetailDTO dto);

}
