package com.example.member.dto;

import lombok.Getter;

@Getter
public class GetMemberResponse {

    private final Long id;
    private final String email;

    public GetMemberResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
