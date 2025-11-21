package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;

public interface StoreCommandService {
    StoreResDTO.addStoreDTO addStore(Long locationId, StoreReqDTO.addStoreDTO dto);
    StoreResDTO.addMissionDTO addMission(Long storeId, StoreReqDTO.addMissionDTO dto);

}