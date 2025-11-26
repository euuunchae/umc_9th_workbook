package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    MISSION_START_OK(HttpStatus.OK,
            "MISSION200_1",
            "미션 도전 시작!"),

    FIND_MISSION_OK(HttpStatus.OK,
            "MISSION200_2",
            "미션 조회가 완료되었습니다."),

    COMPLETE_MISSION_OK(HttpStatus.OK,
            "MEMBER_MISSION200_3",
                    "미션 진행이 완료되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
