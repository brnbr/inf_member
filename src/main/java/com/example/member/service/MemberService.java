package com.example.member.service;

import com.example.member.dto.*;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //post
    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getEmail());
        Member saved = memberRepository.save(member);

        return new MemberCreateResponse(
                saved.getId(),
                saved.getEmail()
        );
    }

    //getAll
    @Transactional(readOnly = true)
    public List<GetMemberResponse> getAll() {
        List<Member> members = memberRepository.findAll();
        List<GetMemberResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            GetMemberResponse dto = new GetMemberResponse(
                    member.getId(),
                    member.getEmail()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    //getOne()
    @Transactional(readOnly = true)
    public GetMemberResponse getOne(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("멤버가 없습니다.")
        );

        return new GetMemberResponse(
                member.getId(),
                member.getEmail()
        );
    }

    //put
    @Transactional
    public MemberUpdateResponse update(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("멤버가 없습니다.")
        );

        member.update(request.getEmail());
        return new MemberUpdateResponse(
                member.getId(),
                member.getEmail()
        );
    }

    //delete
    @Transactional
    public void delete(Long id) {
        boolean existence = memberRepository.existsById(id);

        if(!existence){
            throw new IllegalStateException("멤버가 없습니다.");
        }

        memberRepository.deleteById(id);
    }

}
