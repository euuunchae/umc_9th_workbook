package com.example.umc9th.domain.store.dto;


import com.example.umc9th.domain.store.enums.StoreType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class StoreReqDTO {

    // 특징 지역에 가게 추가 API requestDTO
    public record addStoreDTO(
            @NotBlank
            String name,
            StoreType type,
            String address,
            @NotNull
            BigDecimal score,
            LocalTime open,
            LocalTime close){}


    // 가게에 미션 추가 API requestDTO
    public record addMissionDTO(
            @NotBlank
            String content,
            @NotNull
            Long point,
            @NotNull
            LocalDate deadline
    ){}

}
