package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // @Query 방식
    @Query("select mm " +
            "from MemberMission mm " +
            "where mm.member.id = :memberId " +
            "and mm.status = :status " )
    List<MemberMission> findProgressMissionByMemberId(
            @Param("memberId") Long memberId,
            @Param("status") MissionStatus status);

    // 메서드 생성 방식
    List<MemberMission> findByStatusAndMember(MissionStatus status, Member member);

}
