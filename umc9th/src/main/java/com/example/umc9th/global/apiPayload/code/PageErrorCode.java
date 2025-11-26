package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PageErrorCode implements BaseErrorCode {

    INVALID_PAGE_NUMBER(HttpStatus.NOT_ACCEPTABLE,
            "PAGE406_1",
            "잘못된 페이지 번호입니다. 1 이상의 번호를 입력하세요.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
