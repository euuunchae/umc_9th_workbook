package com.example.umc9th.domain.test.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TestSuccessCode implements BaseSuccessCode {

    TEST_OK(HttpStatus.OK, "TEST200", "테스트가 성공적으로 수행되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
