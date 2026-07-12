package com.example.member.dto;

import lombok.Getter;

@Getter
public class MemberCreateResponse {

    private final Long id;
    private final String email;

    public MemberCreateResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
