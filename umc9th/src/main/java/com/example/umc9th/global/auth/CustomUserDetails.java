package com.example.umc9th.global.auth;

import com.example.umc9th.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 권한을 List 형태로 반환
        return List.of(()-> member.getRole().toString());
    }
    @Override
    public String getPassword() { // 비밀번호 반환
        return member.getPassword();
    }

    @Override
    public String getUsername() { // 아이디 반환 (이메일을 아이디로 사용)
        return member.getEmail();
    }
}
