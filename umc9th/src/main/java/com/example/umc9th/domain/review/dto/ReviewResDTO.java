package com.example.umc9th.domain.review.dto;


import lombok.Builder;

import java.math.BigDecimal;

public class ReviewResDTO {

    @Builder
    public record ReviewResponseDTO(
         Long reviewId,
         Long memberId,
         String content,
         BigDecimal score
    ){}
}
