package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.ReviewResDTO;

public interface ReviewQueryService {

    ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);
    ReviewResDTO.ReviewPreViewListDTO findMyReviewByStoreName(String memberName, String storeName, Integer page);
}
