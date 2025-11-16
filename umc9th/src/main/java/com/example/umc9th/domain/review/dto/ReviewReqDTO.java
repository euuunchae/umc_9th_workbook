package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public class ReviewReqDTO {

    @Builder
    @Getter
    public static class ReviewRequestDTO {
        String Content;
        BigDecimal score;
    }
}
