package org.care.service;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface FoodService {
  public StoreInfo selectStore(StoreInfo storeInfo) throws Exception;
  public DetailInfo selectDetail(DetailInfo detailInfo) throws Exception;
  public List<ReviewInfo> selectReview(ReviewInfo reviewInfo) throws Exception;
  public List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception;
  public List<ReviewInfo> insertReview(ReviewInfo reviewInfo) throws Exception;
  public List<MenuInfo> selectMenu(MenuInfo menuInfo) throws Exception;
  public List<Favorite> selectFavorite(Favorite favorite) throws Exception;
  public StoreInfo login(StoreDTO dto) throws Exception;

}
