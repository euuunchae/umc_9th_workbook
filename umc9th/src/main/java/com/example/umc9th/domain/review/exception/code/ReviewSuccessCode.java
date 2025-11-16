package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    FIND_REVIEW_OK(HttpStatus.OK,
            "REVIEW200_1",
            "리뷰가 정상적으로 조회되었습니다."),

    CREATE_REVIEW_OK(HttpStatus.OK,
            "REVIEW200_2",
            "리뷰 작성 완료!! ><");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
