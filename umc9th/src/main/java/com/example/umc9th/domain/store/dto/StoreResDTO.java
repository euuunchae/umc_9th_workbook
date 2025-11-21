package com.example.umc9th.domain.store.dto;

import com.example.umc9th.domain.store.enums.StoreType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class StoreResDTO {

    @Builder
    public record addStoreDTO(
            Long storeId,
            String name,
            StoreType type,
            String address,
            BigDecimal score,
            LocalTime open,
            LocalTime close

    ) {}

    @Builder
    public record addMissionDTO(
            Long storeId,
            Long missionId,
            String content,
            Long point,
            LocalDate deadline
            ) {}
}
