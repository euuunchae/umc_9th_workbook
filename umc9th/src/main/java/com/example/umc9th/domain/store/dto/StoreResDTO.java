package com.example.umc9th.domain.store.dto;

import lombok.Builder;

import java.time.LocalDate;


public class StoreResDTO {

    @Builder
    public record addMissionDTO(
            Long storeId,
            Long missionId,
            String content,
            Long point,
            LocalDate deadline
            ) {}
}
