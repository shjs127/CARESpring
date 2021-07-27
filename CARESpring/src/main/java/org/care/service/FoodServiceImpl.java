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
import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	public FoodMapper foodMapper;

	@Override
	public StoreInfo selectStore(int storeNo) throws Exception {
		return foodMapper.selectStore(storeNo);
	}

	@Override
	public StoreInfo login(StoreDTO dto) throws Exception {

		return foodMapper.storeLogin(dto);
	}
	

	@Override
	public DetailInfo selectDetail(int storeNo) throws Exception {
			
		return foodMapper.selectDetail(storeNo);
		
	}
	
	@Override
	public List<ReviewDTO> selectReview(int storeNo) throws Exception {
			
		return foodMapper.selectReview(storeNo);
		
	}
	
	
	@Override
	public List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception {
			
		return foodMapper.selectReviewList(reviewInfo);
		
	}
	
	@Override
	public void insertReview(int storeNo,int userNo,ReviewDTO dto) throws Exception {
		
		 foodMapper.insertReview(storeNo,userNo,dto);
		
	}
	
	@Override
	public List<MenuInfo> selectMenu(int storeNo) throws Exception {
			
		return foodMapper.selectMenu(storeNo);
		
	}
	
	@Override
	public List<Favorite> selectFavorite(Favorite favorite) throws Exception {
			
		return foodMapper.selectFavorite(favorite);
		
	}

	@Override
	public void reviewPic(ReviewPic pic) {
		foodMapper.insertPic(pic);
	
	}



	
}
  
  
	
	 

