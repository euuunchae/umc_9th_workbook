package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public class MemberMissionResDTO {

    @Builder
    public record startMissionResDTO(
            Long missionId,
            MissionStatus status,
            LocalDateTime createdAt
    ){}
}
