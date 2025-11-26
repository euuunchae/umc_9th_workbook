package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryServiceImpl;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryServiceImpl reviewQueryService;
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
            @Valid @RequestBody ReviewReqDTO.ReviewRequestDTO requestDTO) {

        return ApiResponse.onSuccess(ReviewSuccessCode.CREATE_REVIEW_OK, reviewCommandService.createReview(storeId, requestDTO));
    }

    // 가게의 리뷰 목록 조회
    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page
    ){

        ReviewSuccessCode code = ReviewSuccessCode.FIND_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }


    /**
     * 9주차 - 1. 내가 작성한 리뷰 목록 조회하기
     */
    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 API",
            description = "특정 사용자가 작성한 모든 리뷰를 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("my/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @RequestParam(defaultValue = "김홍익") String memberName,
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page
    ){

        ReviewSuccessCode code = ReviewSuccessCode.FIND_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewQueryService.findMyReviewByStoreName(memberName, storeName, page));
    }
}
