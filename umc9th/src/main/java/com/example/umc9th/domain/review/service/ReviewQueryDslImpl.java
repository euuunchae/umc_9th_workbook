package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewQueryDsl;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {
//
//    private final ReviewRepository reviewRepository;
//    private final EntityManager em;
//
//    // 검색 API
//    @Override
//    public List<Review> searchMyReviews(Predicate predicate) {
//
//        // JPA 세팅
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//
//        // Q 클래스 선언
//        QReview review = QReview.review;
//        QStore store = QStore.store;
//
//        return queryFactory
//                .selectFrom(review)
//                .leftJoin(store).on(store.id.eq(review.store.id))
//                .where(predicate)
//                .fetch();
//    }
}