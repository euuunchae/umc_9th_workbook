package com.example.umc9th.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {

    // 특정 가게의 미션 목록 조회
    @Builder
    public record MissionPreViewListDTO(
            List<MissionPreViewDTO> missionPreViewDTOList,
            Integer listSize,
            Integer totalPage,
            Integer pageNumber,  // 현재 페이지 번호
            Long totalElements,
            Boolean isFirst,
            Boolean isLast

    ) {
    }

    // 미션 1개
    @Builder
    public record MissionPreViewDTO(
            Long missionId,  // 미션 id
            String content,  // 미션 내용
            Long point,  // 달성 시 포인트
            LocalDate deadLine   // 기한

    ) {}
}
