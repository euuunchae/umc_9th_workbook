package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import org.springframework.data.domain.Page;


public class MissionConverter {

    // MemberMission -> startMissionResDTO
    public static MemberMissionResDTO.startMissionResDTO toStartMissionResDTO(MemberMission memberMission) {
        return MemberMissionResDTO.startMissionResDTO.builder()
                .missionId(memberMission.getId())
                .status(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();

    }

    ///  ===  9주차 2. 특정 가게의 미션 목록 조회    === ///
    public static MissionResDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> result){
        return MissionResDTO.MissionPreViewListDTO.builder()
                .missionPreViewDTOList(result.getContent().stream()
                        .map(MissionConverter::toMissionPreViewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .pageNumber(result.getNumber())  // 현재 페이지 번호
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    // Mission -> MissionPreViewDTO
    public static MissionResDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission) {
        return MissionResDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadLine(mission.getDeadline())
                .build();
    }

    ///  ===  9주차 3. 사용자 미션 목록 조회    === ///
    public static MemberMissionResDTO.MemberMissionPreViewListDTO toMemberMissionPreViewDTOList(Page<MemberMission> result) {
        return MemberMissionResDTO.MemberMissionPreViewListDTO.builder()
                .memberMissionDTOList(result.getContent().stream()
                        .map(MissionConverter::toMemberMissionPreViewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .pageNumber(result.getNumber())  // 현재 페이지 번호
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MemberMissionResDTO.MemberMissionPreViewDTO toMemberMissionPreViewDTO(MemberMission memberMission) {
        return MemberMissionResDTO.MemberMissionPreViewDTO.builder()
                .memberMissionId(memberMission.getId())
                .storeName(memberMission.getMission().getStore().getName())  // 이러면 근데 성능이 너무 안 좋을 것 같은데,,,,
                .content(memberMission.getMission().getContent())
                .status(memberMission.getStatus())
                .deadline(memberMission.getMission().getDeadline())
                .build();
    }

    ///  ===  9주차 4. 진행 완료로 변경하기    === ///
    // MemberMission -> resDTO
    public static MemberMissionResDTO.CompleteMissionResDTO toCompleteMissionResDTO(MemberMission memberMission) {
        return MemberMissionResDTO.CompleteMissionResDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

}
