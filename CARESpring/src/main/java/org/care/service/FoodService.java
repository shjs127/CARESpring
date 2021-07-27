package org.care.service;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.ReviewPic;
import org.care.domain.StoreInfo;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;

public interface FoodService {
	  public StoreInfo selectStore(int storeNo) throws Exception;
	  public DetailInfo selectDetail(int storeNo) throws Exception;
	  public List<ReviewDTO> selectReview(int storeNo) throws Exception;
	  public List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception;
	  public List<MenuInfo> selectMenu(int storeNo) throws Exception;
	  public List<Favorite> selectFavorite(Favorite favorite) throws Exception;
	  public StoreInfo login(StoreDTO dto) throws Exception;
	 void insertReview(int storeNo, int userNo, ReviewDTO dto) throws Exception;
	public void reviewPic(ReviewPic pic);

}
