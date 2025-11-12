package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.test.dto.TestResDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    // List 로 받은 Review 객체들을 ReviewResponseDTO 리스트로 묶음
    public static List<ReviewResDTO.ReviewResponseDTO> toReviewResponseDTOList(List<Review> reviews){
        return reviews.stream()
                .map(review -> ReviewResDTO.ReviewResponseDTO.builder()
                        .reviewId(review.getId())
                        .content(review.getContent())
                        .score(review.getScore())
                        .build())
                .collect(Collectors.toList());
    }

}
