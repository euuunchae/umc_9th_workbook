package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
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
                .content(dto.content())
                .score(dto.score())
                .store(store)
                .build();
    }


    // result -> DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getContent())
                .createdAt(LocalDateTime.from(review.getCreatedAt()))
                .build();
    }

}
