package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entity.Review;;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    // 내가 작성한 리뷰 보기 API
    // 필터링 조건 : 가게별, 별점별
    @GetMapping("my/reviews")
    public List<Review> searchMyReviews(
            @RequestParam String query,  // 조건 - 가게, 별점
            @RequestParam String type  // 해당 조건의 타입
    ) {
        List<Review> result = reviewQueryService.searchMyReviews(query, type);
        return result;

    }
}
