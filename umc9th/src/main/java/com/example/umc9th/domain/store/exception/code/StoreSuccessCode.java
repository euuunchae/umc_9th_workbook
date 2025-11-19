package com.example.umc9th.domain.store.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode {

    ADD_MISSION_OK(HttpStatus.OK,
            "STORE200_1",
            "미션 추가가 완료되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
