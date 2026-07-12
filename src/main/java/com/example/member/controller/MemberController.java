package com.example.member.controller;

import com.example.member.dto.*;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //CREATE
    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create(
            @RequestBody MemberCreateRequest request
    ) {
        return ResponseEntity.ok(memberService.save(request));
    }

    //getAll
    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

    //getOne
    @GetMapping("/members/{id}")
    public ResponseEntity<GetMemberResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getOne(id));
    }

    //update
    @PutMapping("/members/{id}")
    public ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long id,
            @RequestBody MemberUpdateRequest request
    ) {
        return ResponseEntity.ok(memberService.update(id, request));
    }

    //delete
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
