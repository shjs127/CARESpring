package org.care.mapper;

import org.care.domain.ReviewInfo;
import org.care.dto.ReviewDTO;

public interface ReviewMapper {
	ReviewInfo selectReview(ReviewDTO dto) throws Exception;
}
