package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ReviewResDTO.ReviewResponseDTO createReview(Long storeId, ReviewReqDTO.ReviewRequestDTO requestDTO){

        Member member = getUser(1L);
        Store store = storeRepository.findById(storeId).orElseThrow(()->new StoreException(StoreErrorCode.STORE_NOT_FOUND));
        Review review = ReviewConverter.toReview(store, member, requestDTO);
        reviewRepository.save(review);

        return ReviewConverter.toReviewResponseDTO(review);
    }

    private Member getUser(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()->new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
    }
}
