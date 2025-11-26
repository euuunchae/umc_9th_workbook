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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    /**
     * 9주차 - 3. 특정 사용자의 미션 목록 조회하기
     */
    public MemberMissionResDTO.MemberMissionPreViewListDTO getMemberMissionByMissionStatus(Long memberId, MissionStatus status, Integer page) {

        // 사용자 찾기
        Member member = getUser(memberId);

        // 사용자의 미션 찾기
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<MemberMission> memberMissions = memberMissionRepository.findByMemberAndStatus(member, status, pageRequest);

        return MissionConverter.toMemberMissionPreViewDTOList(memberMissions);
    }

    /**
     * 9주차 - 4. 미션 진행 완료로 변경하기
     */
    @Transactional
    public MemberMissionResDTO.CompleteMissionResDTO completeMemberMission(Long memberMissionId) {

        // 사용자의 미션 찾기
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(()->new MissionException(MissionErrorCode.MEMBER_MISSION_NOT_FOUND));

        // 미션 완료 상태 변경하기
        memberMission.updateMissionStatus(MissionStatus.COMPLETE);

        return MissionConverter.toCompleteMissionResDTO(memberMission);

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
