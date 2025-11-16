package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    /**
     *  리뷰 작성하기
     */
    @Override
    public ReviewResDTO.ReviewResponseDTO createReview(Long storeId, ReviewReqDTO.ReviewRequestDTO requestDTO){

        Member member = memberRepository.findById(3L).orElseThrow(()->new MemberException("Member not found"));
        Store store = storeRepository.findById(storeId).orElseThrow(()->new ReviewException("Store not found"));
        Review review = ReviewConverter.toReview(store, member,requestDTO);
        reviewRepository.save(review);

        return ReviewConverter.toReviewResponseDTO(review);
    }
}
