package me.coffeemori.hellospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.coffeemori.hellospring.domains.Member;
import me.coffeemori.hellospring.repositories.MemberRepository;

@Transactional
public class MemberService {
  
  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  
  // 회원 가입
  public Long join(Member member) {
      validateDuplicateMember(member); // 중복회원 검증
      memberRepository.save(member);
      return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
      .ifPresent(m -> {
        throw new IllegalStateException("이미 존재하는 회원입니다.");
      });
  }

  // 전체 회원 조회
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  // 멤버 하나 조회
  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
