package com.example.umc9th.domain.store.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class StoreReqDTO {

    public record addMissionDTO(
            @NotBlank
            String content,
            @NotNull
            Long point,
            @NotNull
            LocalDate deadline
    ){}

}
