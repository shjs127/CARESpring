package org.care.service;


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
	public Integer read(int reviewNo) throws Exception {
		
		
		return foodMapper.read(reviewNo);
		
		
	}
	
	
}
  
  
	
	 

