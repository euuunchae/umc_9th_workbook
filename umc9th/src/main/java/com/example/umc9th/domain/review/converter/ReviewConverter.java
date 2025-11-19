package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    // List 로 받은 Review 객체들을 ReviewResponseDTO 리스트로 묶음
    public static List<ReviewResDTO.ReviewResponseDTO> toReviewResponseDTOList(List<Review> reviews){
        return reviews.stream()
                .map(review -> ReviewResDTO.ReviewResponseDTO.builder()
                        .reviewId(review.getId())
                        .memberId(review.getMember().getId())
                        .content(review.getContent())
                        .score(review.getScore())
                        .build())
                .collect(Collectors.toList());
    }

    // review -> reviewResponseDTO
    public static ReviewResDTO.ReviewResponseDTO toReviewResponseDTO(Review review){
        return ReviewResDTO.ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .score(review.getScore())
                .content(review.getContent())
                .build();
    }


    // reviewRequestDTO -> review 객체 변환
    public static Review toReview(Store store, Member member, ReviewReqDTO.ReviewRequestDTO dto){
        return Review.builder()
                .member(member)
                .content(dto.getContent())
                .score(dto.getScore())
                .store(store)
                .build();
    }

}
