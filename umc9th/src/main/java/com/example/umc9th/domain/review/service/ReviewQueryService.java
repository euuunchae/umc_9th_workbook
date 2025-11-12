package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchMyReviews(String query, String type) {

        // Q 클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 동적 쿼리 : 검색 조건
        if (type.equals("store")) {
            builder.and(review.store.name.contains(query));
        }

        if (type.equals("score")) {
            builder.and(review.score.goe(Float.parseFloat(query)));
        }

        List<Review> reviewList = reviewRepository.searchMyReviews(builder);

        return reviewList;
    }

}
