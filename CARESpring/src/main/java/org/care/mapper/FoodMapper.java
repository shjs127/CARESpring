package org.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.ReviewPaging;
import org.care.domain.ReviewPic;
import org.care.domain.StoreInfo;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;

public interface FoodMapper {
	StoreInfo selectStore(int storeNo) throws Exception;
	DetailInfo selectDetail(int storeNo) throws Exception;
	List<ReviewDTO> selectReview(int storeNo) throws Exception;
	double selectAvg(int storeNo) throws Exception;
	
	List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception;
	List<MenuInfo> selectMenu(int storeNo) throws Exception;
	List<Favorite> selectFavorite(int userNo) throws Exception;

	void deleteReview(int reviewNo) throws Exception;
	List<ReviewInfo> selectReviewDetail(@Param("reviewNo")int reviewNo)throws Exception;
	void modifyReview(@Param("reviewNo")int reviewNo, @Param("reviewContents")String reviewContents, @Param("avgScore")int avgScore)throws Exception;
	
	StoreInfo storeLogin(StoreDTO dto) throws Exception;
	void insertReview(int storeNo, int userNo, ReviewDTO dto);
	void insertPic(ReviewPic pic);
	
	
	//페이징 관련 코드
	public int countReview();
	public List<ReviewInfo> selectReviewP(ReviewPaging reviewPaging);
	
}
