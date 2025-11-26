package com.example.umc9th.domain.review.dto;

import lombok.Builder;

import java.math.BigDecimal;

public class ReviewReqDTO {

    @Builder
    public record ReviewRequestDTO(
        String content,
        Float score){}
}
