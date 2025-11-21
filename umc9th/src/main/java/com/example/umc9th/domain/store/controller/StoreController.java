package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.exception.code.StoreSuccessCode;
import com.example.umc9th.domain.store.service.command.StoreCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    /**
     * 1. 특정 지역에 가게 추가하기 API
     */
    @PostMapping("/location/{locationId}/stores")
    public ApiResponse<StoreResDTO.addStoreDTO> addStore(
            @PathVariable("locationId") Long locationId,
            @Valid @RequestBody StoreReqDTO.addStoreDTO dto) {
        return ApiResponse.onSuccess(StoreSuccessCode.ADD_STORE_OK, storeCommandService.addStore(locationId, dto));
    }



    /**
     * 3. 가게에 미션 추가하기 API
     */
    @PostMapping("/stores/{storeId}/missions")
    public ApiResponse<StoreResDTO.addMissionDTO> addMission(
            @PathVariable("storeId") Long storeId,
            @Valid @RequestBody StoreReqDTO.addMissionDTO dto) {
        return ApiResponse.onSuccess(StoreSuccessCode.ADD_MISSION_OK, storeCommandService.addMission(storeId, dto));
    }
}
