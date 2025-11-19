package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.service.ReviewCommandService;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

//    // 내가 작성한 리뷰 보기 API
//    // 필터링 조건 : 가게별, 별점별
//    @GetMapping("my/reviews")
//    public ApiResponse<List<ReviewResDTO.ReviewResponseDTO>> searchMyReviews(
//            @RequestParam String query,  // 조건 - 가게, 별점
//            @RequestParam String type  // 해당 조건의 타입
//    ) {
//        List<Review> result = reviewQueryService.searchMyReviews(query, type);
//
//        ReviewSuccessCode code = ReviewSuccessCode.FIND_REVIEW_OK;
//        return ApiResponse.onSuccess(
//                code, ReviewConverter.toReviewResponseDTOList(result));
//    }

    /**
     * 2. 가게에 리뷰 추가하기 API
     */
    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewResponseDTO> createReview(
            @PathVariable Long storeId,
            @Valid @RequestBody ReviewReqDTO.ReviewRequestDTO requestDTO){

        return ApiResponse.onSuccess(ReviewSuccessCode.CREATE_REVIEW_OK, reviewCommandService.createReview(storeId, requestDTO));
    }
}
