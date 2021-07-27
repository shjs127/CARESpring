package org.care.service;


import java.util.List;

import org.care.domain.ReviewInfo;
import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyFoodServiceImpl implements ModifyFoodService {
	
	@Autowired
	private FoodMapper foodMapper;

	@Override
	public void modifyReview(int reviewNo, String reviewContents,int avgScore) throws Exception {
		foodMapper.modifyReview(reviewNo,reviewContents,avgScore);
		
		
	}
	
	@Override
	public List<ReviewInfo> selectReviewDetail(int reviewNo) throws Exception {
		return foodMapper.selectReviewDetail(reviewNo);
	}
	
}
  
  
	
	 

