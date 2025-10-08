package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.entity.mapping.MemberTerm;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.Social;
import com.example.umc9th.domain.member.enums.MemberStatus;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "social", nullable = false)
    private Social social;

    @Column(name = "status", nullable = false)
    private MemberStatus status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberTerm> memberTermList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberFood> memberFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
