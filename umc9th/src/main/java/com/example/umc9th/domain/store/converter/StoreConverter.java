package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;

public class StoreConverter {

    // reqDTO -> Mission
    public static Mission toMission(Store store, StoreReqDTO.addMissionDTO dto) {
        return Mission.builder()
                .content(dto.content())
                .point(dto.point())
                .deadline(dto.deadline())
                .store(store)
                .build();
    }

    // Mission -> resDTO
    public static StoreResDTO.addMissionDTO toAddMissionResDTO(Mission mission) {
        return StoreResDTO.addMissionDTO.builder()
                .storeId(mission.getStore().getId())
                .missionId(mission.getId())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .build();
    }
}
