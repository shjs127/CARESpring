package org.care.mapper;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;

public interface FoodMapper {
	StoreInfo selectStore(StoreInfo storeInfo) throws Exception;
	DetailInfo selectDetail(DetailInfo detailInfo) throws Exception;
	List<ReviewInfo> selectReview(ReviewInfo reviewInfo) throws Exception;
	List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception;
	List<ReviewInfo> insertReview(ReviewInfo reviewInfo) throws Exception;
	/* void deleteReview(List<ReviewInfo> reviewInfoList) throws Exception; */
	List<MenuInfo> selectMenu(MenuInfo menuInfo) throws Exception;
	List<Favorite> selectFavorite(Favorite favorite) throws Exception;
	void deleteReview(List<ReviewInfo> reviewInfoList) throws Exception;
	
	StoreInfo storeLogin(StoreDTO dto) throws Exception;
}
