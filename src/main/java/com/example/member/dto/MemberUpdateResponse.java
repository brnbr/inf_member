package com.example.member.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponse {

    private final Long id;
    private final String email;

    public MemberUpdateResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
