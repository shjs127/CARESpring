package org.care.service;

import org.care.domain.ReviewInfo;
import org.care.dto.ReviewDTO;

public interface ReviewService {

  public ReviewInfo review(ReviewDTO dto) throws Exception;



	
}
