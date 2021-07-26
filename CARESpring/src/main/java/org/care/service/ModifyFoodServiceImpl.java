package org.care.service;


import org.care.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyFoodServiceImpl implements ModifyFoodService {
	
	@Autowired
	private FoodMapper foodMapper;

	@Override
	public void modifyReview(int reviewNo) throws Exception {
		foodMapper.modifyReview(reviewNo);
	}
	@Override
	public Integer read(int reviewNo) throws Exception {
		
		
		return foodMapper.read(reviewNo);
		
		
	}
	
}
  
  
	
	 

