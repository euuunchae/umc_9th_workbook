package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select m " +
            "from Mission m " +
            "where m.store.id = :storeId " +
            "and m.deadline > CURRENT_TIMESTAMP " +
            "and not exists ( select mm from MemberMission mm where mm.mission = m and mm.member.id = :memberId)")
    List<Mission> findByMemberIdAndStoreId(
            @Param("memberId") Long memberId,
            @Param("storeId") Long storeId);


    Page<Mission> findByStoreOrderByDeadlineAsc(Store store, Pageable pageable);


}
