package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("select mm " +
            "from MemberMission mm " +
            "join fetch mm.mission m " +
            "where mm.member = :member " +
            "and mm.status = :status " )
    Page<MemberMission> findByMemberAndStatus(
            @Param("member") Member member,
            @Param("status") MissionStatus status,
            Pageable pageable);


}
