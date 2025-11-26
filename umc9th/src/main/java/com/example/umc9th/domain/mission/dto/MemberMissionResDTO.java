package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResDTO {

    // 미션 도전용 DTO
    @Builder
    public record startMissionResDTO(
            Long missionId,
            MissionStatus status,
            LocalDateTime createdAt
    ) {}

    // 미션 조회용 DTO
    @Builder
    public record MemberMissionPreViewListDTO(
            List<MemberMissionPreViewDTO> memberMissionDTOList,
            Integer listSize,
            Integer totalPage,
            Integer pageNumber,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MemberMissionPreViewDTO(
            Long memberMissionId,
            MissionStatus status,
            String storeName,
            String content,
            LocalDate deadline

    ){}

    @Builder
    public record CompleteMissionResDTO(
            Long memberMissionId,
            MissionStatus status,
            LocalDateTime updatedAt  // 진행 완료 시간
    ){}
}