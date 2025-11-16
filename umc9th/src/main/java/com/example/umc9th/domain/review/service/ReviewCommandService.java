package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.store.entity.Store;

public interface ReviewCommandService {
    ReviewResDTO.ReviewResponseDTO createReview(Long storeId, ReviewReqDTO.ReviewRequestDTO dto);
}
