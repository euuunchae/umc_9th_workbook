package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MemberMissionResDTO.startMissionResDTO startMission(Long missionId) {

        Mission mission = getMission(missionId);
        Member member = getUser(1L);

        // MemberMission 객체 생성 - status를 PROGRESS로 설정해서 도전 중인 미션으로 처리하기
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.PROGRESS)
                .build();
        memberMissionRepository.save(memberMission);

        return MissionConverter.toStartMissionResDTO(memberMission);
    }

    private Member getUser(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()->new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
    }

    private Mission getMission(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(()->new MissionException(MissionErrorCode.MISSION_NOT_FOUND));
    }
}
