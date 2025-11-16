package com.example.umc9th.domain.review.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public class ReviewResDTO {

    @Builder
    @Getter
    public static class ReviewResponseDTO {
        private Long reviewId;
        private Long memberId;
        private String content;
        private BigDecimal score;

    }
}
