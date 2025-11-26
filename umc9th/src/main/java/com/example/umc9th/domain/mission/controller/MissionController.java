package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.global.annotation.InvalidPageNum;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionController {

    private final MemberMissionService memberMissionService;
    private final MissionService missionService;

    /**
     * 4. 미션 도전하기 API
     */
    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberMissionResDTO.startMissionResDTO> startMission(@PathVariable Long missionId) {
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_START_OK, memberMissionService.startMission(missionId));
    }


    /**
     * 9주차 - 2. 특정 가게의 미션 목록 조회하기
     */
    @Operation(
            summary = "9주차 - 2. 특정 가게의 미션 목록 조회 API",
            description = "특정 가게의 모든 미션을 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissionsByStore(
            @PathVariable Long storeId,
            @InvalidPageNum @RequestParam(defaultValue = "1") Integer page
    ) {

        return ApiResponse.onSuccess(MissionSuccessCode.FIND_MISSION_OK, missionService.getMissionByStore(storeId, page) );

    }

    /**
     * 9주차 - 3. 내가 진행중인 미션 목록 조회하기
     */
    @Operation(
            summary = "9주차 3. 나의 미션 목록 조회 API",
            description = "특정 사용자가 진행 중인/진행 완료한 미션 목록을 조회합니다. " +
                    "쿼리 스트링으로 미션 상태를 입력받습니다. ( 진행중-PROGRESS / 진행완료-COMPLETE )" +
                    "페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/members/{memberId}/missions")
    public ApiResponse<MemberMissionResDTO.MemberMissionPreViewListDTO> getProgressingMission(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "PROGRESS") MissionStatus status,
            @InvalidPageNum @RequestParam(defaultValue = "1") Integer page
    ) {

        return ApiResponse.onSuccess(MissionSuccessCode.FIND_MISSION_OK, memberMissionService.getMemberMissionByMissionStatus(memberId, status, page));
    }

    /**
     * 9주차 - 4. 미션 상태 '진행중' -> '진행완료' 변경
     */
    @Operation(
            summary = "9주차 4. 미션 상태 진행 중 -> 진행 완료 변경 API",
            description = "미션 상태를 PROGRESS에서 COMPLETE로 변경합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @PostMapping("/member_missions/{memberMissionId}/complete")
    public ApiResponse<MemberMissionResDTO.CompleteMissionResDTO> completeMission(
            @PathVariable Long memberMissionId) {

        return ApiResponse.onSuccess(MissionSuccessCode.COMPLETE_MISSION_OK, memberMissionService.completeMemberMission(memberMissionId));
    }

}
