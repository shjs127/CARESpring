package org.care.service;

import java.util.List;

import org.care.domain.ReviewInfo;

public interface ModifyFoodService {
	public void modifyReview(int reviewNo, String reviewContents, int avgScore) throws Exception;
	List<ReviewInfo> selectReviewDetail(int reviewNo) throws Exception;
	
}
