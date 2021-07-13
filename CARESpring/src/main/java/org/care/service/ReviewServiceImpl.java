package org.care.service;

import org.care.domain.ReviewInfo;
import org.care.dto.ReviewDTO;
import org.care.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  private ReviewMapper reviewMapper;

  @Override
  @Transactional
  public ReviewInfo review(ReviewDTO dto) throws Exception {

    return reviewMapper.selectReview(dto);
  }


	
	 
}
