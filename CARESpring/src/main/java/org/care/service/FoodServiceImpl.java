package org.care.service;

import java.util.List;

import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	public FoodMapper foodMapper;

	@Override
	public StoreInfo selectStore(StoreInfo storeInfo) throws Exception {
		return foodMapper.selectStore(storeInfo);
	}

	@Override
	public StoreInfo login(StoreDTO dto) throws Exception {

		return foodMapper.storeLogin(dto);
	}
	

	@Override
	public DetailInfo selectDetail(DetailInfo detailInfo) throws Exception {
			
		return foodMapper.selectDetail(detailInfo);
		
	}
	
	@Override
	public List<ReviewInfo> selectReview(ReviewInfo reviewInfo) throws Exception {
			
		return foodMapper.selectReview(reviewInfo);
		
	}
	
	@Override
	public List<ReviewInfo> selectReviewList(ReviewInfo reviewInfo) throws Exception {
			
		return foodMapper.selectReviewList(reviewInfo);
		
	}
	
	
	  @Override
	  public void deleteReview(List<ReviewInfo> reviewInfoList) throws Exception {
	  
	  foodMapper.deleteReview(reviewInfoList);
	 
	  }
	
	
	@Override
	public List<ReviewInfo> insertReview(ReviewInfo reviewInfo) throws Exception {
		
		return foodMapper.insertReview(reviewInfo);
		
	}
	
	@Override
	public List<MenuInfo> selectMenu(MenuInfo menuInfo) throws Exception {
			
		return foodMapper.selectMenu(menuInfo);
		
	}
	
	@Override
	public List<Favorite> selectFavorite(Favorite favorite) throws Exception {
			
		return foodMapper.selectFavorite(favorite);
		
	}

	
}
  
  
	
	 

