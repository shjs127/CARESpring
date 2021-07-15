package org.care.service;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.MenuDTO;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;

public interface FoodService {

  public List<StoreInfo> selectStore(StoreDTO dto) throws Exception;
  public List<DetailInfo> selectDetail(DetailDTO dto) throws Exception;
  public List<ReviewInfo> selectReview(ReviewDTO dto) throws Exception;
  public List<MenuInfo> selectMenu(MenuDTO dto) throws Exception;
  
  public StoreInfo login(StoreDTO dto) throws Exception;
}
