package org.care.service;

import java.util.List;

import org.care.domain.ReviewInfo;

public interface DeleteFoodService {
	public void deleteReview(int reviewNo) throws Exception; 
	List<ReviewInfo> selectReviewDetail(int reviewNo) throws Exception;

	
	
	

}
