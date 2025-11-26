package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    /**
     * 9주차 - 2. 특정 가게의 미션 목록 조회하기
     */
    public MissionResDTO.MissionPreViewListDTO getMissionByStore(Long storeId, Integer page) {

        // 가게 찾기
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        // 미션 목록 조회하기
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Mission> missions = missionRepository.findByStoreOrderByDeadlineAsc(store, pageRequest);

        return MissionConverter.toMissionPreViewListDTO(missions);
    }
}
