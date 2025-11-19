package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public StoreResDTO.addMissionDTO addMission(Long storeId, StoreReqDTO.addMissionDTO dto) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        Mission mission = StoreConverter.toMission(store, dto);
        missionRepository.save(mission);

        return StoreConverter.toAddMissionResDTO(mission);

    }
}
