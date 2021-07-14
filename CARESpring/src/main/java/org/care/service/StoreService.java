package org.care.service;

import java.util.List;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface StoreService {

  public List<StoreInfo> selectStore(StoreDTO dto) throws Exception;

}
