package org.care.mapper;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.MenuDTO;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;

public interface FoodMapper {
	List<StoreInfo> selectStore(StoreDTO dto) throws Exception;
	List<DetailInfo> selectDetail(DetailDTO dto) throws Exception;
	List<ReviewInfo> selectReview(ReviewDTO dto) throws Exception;
	List<MenuInfo> selectMenu(MenuDTO dto) throws Exception;
	
	List<ReviewInfo> insertReview(ReviewDTO dto) throws Exception;
	StoreInfo storeLogin(StoreDTO dto) throws Exception;
}
