package org.care.service;


import java.util.List;

import org.care.domain.ReviewInfo;
import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFoodServiceImpl implements DeleteFoodService {
	
	@Autowired
	private FoodMapper foodMapper;


	@Override
	public void deleteReview(int reviewNo) throws Exception {
		foodMapper.deleteReview(reviewNo);
	}
	
	@Override
	public List<ReviewInfo> selectReviewDetail(int reviewNo) throws Exception {
		
		
		return foodMapper.selectReviewDetail(reviewNo);
		
		
	}
	
	
}
  
  
	
	 

