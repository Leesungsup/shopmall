package com.shop.service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member saveMember(Member member){
        validateDuplicatieMember(member);
        return memberRepository.save(member);
    }
    public void validateDuplicatieMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember!=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
