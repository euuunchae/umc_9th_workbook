package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MemberMissionService memberMissionService;

    /**
     * 4. 미션 도전하기 API
     */
    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberMissionResDTO.startMissionResDTO> startMission(@PathVariable Long missionId) {
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_START_OK, memberMissionService.startMission(missionId));
    }
}
