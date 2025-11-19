package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;

public class MissionConverter {

    // MemberMission -> startMissionResDTO
    public static MemberMissionResDTO.startMissionResDTO toStartMissionResDTO(MemberMission memberMission) {
        return MemberMissionResDTO.startMissionResDTO.builder()
                .missionId(memberMission.getId())
                .status(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();

    }
}
